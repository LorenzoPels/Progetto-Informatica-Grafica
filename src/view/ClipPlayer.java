
package view;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class ClipPlayer {

    private final int DEFAULT_NUM_CLIPS = 5;

    private int clipArrayIndex = 0;
    private Clip[] audioClipArray;

    private ClipPlayer() {
        //forbidden constructor
    }

    public ClipPlayer(String file) throws FileNotFoundException, UnsupportedAudioFileException, IOException {
        File audioFile = new File(file);
        AudioFileFormat aff = AudioSystem.getAudioFileFormat(audioFile);
        AudioFormat af = aff.getFormat();

        int numClips = computeNumClips();
        this.audioClipArray = new Clip[numClips];
        for (int i = 0; i < this.audioClipArray.length; i++)
            this.audioClipArray[i] = getClip(audioFile, af);

    } // end constructor

    private int computeNumClips() {
        // to-do
        return DEFAULT_NUM_CLIPS;
    }

    private Clip getClip(File audioFile, AudioFormat af) throws UnsupportedAudioFileException, IOException {
        Clip audioClip = null;
        AudioInputStream ais = null;

        try {
            ais = AudioSystem.getAudioInputStream(audioFile);
            int bufferSize = (int)ais.getFrameLength() * af.getFrameSize();
            DataLine.Info dataLineInfo = new DataLine.Info(Clip.class, ais.getFormat(), bufferSize);

            if (!AudioSystem.isLineSupported(dataLineInfo))
                throw new IOException("Error: the AudioSystem does not support the specified DataLine.Info object");

            try {
                audioClip = (Clip)AudioSystem.getLine(dataLineInfo);
                audioClip.open(ais);
                audioClip.setFramePosition(audioClip.getFrameLength());
            }
            catch(LineUnavailableException lue) {
                throw new IOException("Error: a LineUnavailableException exception was thrown");
            }

        }
        catch(UnsupportedAudioFileException uafe) {
            uafe.printStackTrace();
        }
        catch(IOException ioe) {
            ioe.printStackTrace();
        }
        finally {
            if (ais != null)
                ais.close();
        }
        return audioClip;
    } // end method getClip()

    public void play() {
        //System.out.println("PLAY, this.clipArrayIndex = " + this.clipArrayIndex);
        this.audioClipArray[this.clipArrayIndex].loop(1);
        this.clipArrayIndex++;
        //this.clipArrayIndex = this.clipArrayIndex % this.audioClipArray.length;
        this.clipArrayIndex %= this.audioClipArray.length; // it is equivalent to the previous instruction, but it is more compact
    }

    public void close() {
        for (int i = 0; i < this.audioClipArray.length; i++)
            this.audioClipArray[i].close();
    }
} // end class