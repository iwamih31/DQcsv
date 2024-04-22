package iwamih31.DQcsv;

import java.io.IOException;
import java.io.InputStream;

import javax.sound.sampled.AudioFormat;

public class SquareWave {
	//周波数
	private float frequency;

	//振幅
	private byte amplitude;

	//サンプリングレート
	private float sampleRate;

	private byte[] data;

	public SquareWave(float frequency, byte amplitude, float sampleRate) {
		this.setFrequency(frequency);
		this.amplitude = amplitude;
		this.sampleRate = sampleRate;
		int dataSize = (int)((1 / frequency) * sampleRate);
		data = new byte[dataSize];
		makeWave();
	}

	private void makeWave() {
		for (int i = 0; i < data.length; i++) {
			byte d = amplitude;
			if (i >= data.length / 2)
			d = (byte)(d * -1);
			data[i] = d;
		}
	}

	public AudioFormat getAudioFormat() {
		return new AudioFormat(sampleRate, 8, 1, true, true);
	}

	public InputStream getInputStream(int playTime) {
		return new WaveInputStream(playTime);
	}

	public float getFrequency() {
		return frequency;
	}

	public void setFrequency(float frequency) {
		this.frequency = frequency;
	}

	//データのアクセス用に InputStream を使うことにしました。
	private class WaveInputStream extends InputStream {
		private long frameLength;
		private long framePos;
		private int index;

		private WaveInputStream(int playTime) {
			frameLength = (long)((sampleRate / 1000) * playTime);
			framePos = 0;
			index = 0;
		}

		@Override
		public int read() throws IOException {
			if (framePos >= frameLength) {
				return -1;
			}
			framePos++;
			if (index >= data.length) index = 0;
			int i = index;
			index++;
			return 0xFF & data[i];
		}
	}
}

