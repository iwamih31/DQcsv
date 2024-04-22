package iwamih31.DQcsv;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JOptionPane;

public class Music {

	private String mediaURI;

	private Clip clip;

	private String mediaDirectory = "media/";

	public Music(String mediaName) {
		String resourceName = mediaName + ".wav";
		if (clip == null) {
			URL resourceURL = this.getClass().getClassLoader().getResource(mediaDirectory + resourceName);
			mediaURI = resourceURL.toString();
			clip = createClip(resourceURL);
		}
	}

	public static Clip createClip(File path) {
		String errorMessage = "";
		//指定されたURLのオーディオ入力ストリームを取得
		try (AudioInputStream ais = AudioSystem.getAudioInputStream(path)){
			//ファイルの形式取得
			AudioFormat af = ais.getFormat();
			//単一のオーディオ形式を含む指定した情報からデータラインの情報オブジェクトを構築
			DataLine.Info dataLine = new DataLine.Info(Clip.class,af);
			//指定された Line.Info オブジェクトの記述に一致するラインを取得
			Clip c = (Clip)AudioSystem.getLine(dataLine);
			//再生準備完了
			c.open(ais);
			return c;
		} catch (MalformedURLException e) {
			e.printStackTrace();
			errorMessage = e.getMessage();
		} catch (UnsupportedAudioFileException e) {
			e.printStackTrace();
			errorMessage = e.getMessage();
		} catch (IOException e) {
			e.printStackTrace();
			errorMessage = e.getMessage();
		} catch (LineUnavailableException e) {
			e.printStackTrace();
			errorMessage = e.getMessage();
		}
		JOptionPane.showMessageDialog(null, "createClip(" + path + ") 出来ませんでした");
		JOptionPane.showMessageDialog(null, errorMessage);
		return null;
	}

	public static Clip createClip(URL resourceURL) {
		String errorMessage = "";
		//指定されたURLのオーディオ入力ストリームを取得
		try (AudioInputStream ais = AudioSystem.getAudioInputStream(resourceURL)){
			//ファイルの形式取得
			AudioFormat af = ais.getFormat();
			//単一のオーディオ形式を含む指定した情報からデータラインの情報オブジェクトを構築
			DataLine.Info dataLine = new DataLine.Info(Clip.class,af);
			//指定された Line.Info オブジェクトの記述に一致するラインを取得
			Clip c = (Clip)AudioSystem.getLine(dataLine);
			//再生準備完了
			c.open(ais);
			return c;
		} catch (MalformedURLException e) {
			e.printStackTrace();
			errorMessage = e.getMessage();
		} catch (UnsupportedAudioFileException e) {
			e.printStackTrace();
			errorMessage = e.getMessage();
		} catch (IOException e) {
			e.printStackTrace();
			errorMessage = e.getMessage();
		} catch (LineUnavailableException e) {
			e.printStackTrace();
			errorMessage = e.getMessage();
		}
		JOptionPane.showMessageDialog(null, "createClip(" + resourceURL + ") 出来ませんでした");
		JOptionPane.showMessageDialog(null, errorMessage);
		return null;
	}

	public void play() {
		System.out.println("");////////////////////////
		System.out.println(mediaURI + " を再生します");
		System.out.println("");////////////////////////
		clip.start();
	}

	public void playRepeat() {
		System.out.println("");////////////////////////
		System.out.println(mediaURI + " をループ再生します");
		System.out.println("");////////////////////////
		clip.loop(Clip.LOOP_CONTINUOUSLY);
	}

	public void pause() {
		System.out.println("");////////////////////////
		System.out.println(mediaURI + " を一時停止します");
		System.out.println("");////////////////////////
		clip.stop();
	}

	public void stop() {
		System.out.println("");////////////////////////
		System.out.println(mediaURI + " を停止します");
		System.out.println("");////////////////////////
		clip.stop();
		clip.flush();
		clip.setFramePosition(0);
		clip.close();
	}

	public void fade_out() {
		FloatControl ctrl = (FloatControl)clip.getControl(FloatControl.Type.MASTER_GAIN);
		for ( int i = 100;i >= 0;i-- ) {
			ctrl.setValue((float)Math.log10((float)i / 100)*20);
		}
	}
}
