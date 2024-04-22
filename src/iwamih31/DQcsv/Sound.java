package iwamih31.DQcsv;

import java.io.IOException;
import java.io.InputStream;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;

public class Sound {

	public Sound(float frequency, int soundLength) throws LineUnavailableException {

		SquareWave wave = new SquareWave(frequency, (byte)10, 44100);

		SourceDataLine line = AudioSystem.getSourceDataLine(wave.getAudioFormat());
		line.open(wave.getAudioFormat());
		line.start();

		InputStream in = wave.getInputStream(soundLength); // 音の長さ

		byte[] b = new byte[1024];
		int len = 0;
		try {
			while ((len = in.read(b)) > -1) {
				line.write(b, 0, len);
			}
			line.drain();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		line.close();
	}

	public Sound() throws LineUnavailableException {
		this(440f,100);
	}
}



