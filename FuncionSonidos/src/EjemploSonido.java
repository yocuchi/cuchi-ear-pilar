import javazoom.jl.player.advanced.*;

public class EjemploSonido
{
    public static void main(String[] args)
    {
        
    	
    	
    	SoundJLayer PedoSound = new SoundJLayer("fart-01.mp3");

        //PedoSound.play();
        
        SoundJLayer MotoSound = new SoundJLayer("chainsaw-01.mp3");

        //MotoSound.play();
        
        int suerte=(int) ((Math.random())*100);
        
        if (suerte>50){
        	System.out.println(" Has tenido suerte");
        	System.out.println("Solo te llevas un pedo");
        	PedoSound.play();
        }
        else{
        	System.out.println(" Has tenido poca suerte");
        	System.out.println(" te cortare en cachitos");
        	MotoSound.play();
        }

        
    }
}

class SoundJLayer extends PlaybackListener implements Runnable
{
    private String filePath;
    private AdvancedPlayer player;
    private Thread playerThread;    

    public SoundJLayer(String filePath)
    {
        this.filePath = filePath;
    }

    public void play()
    {
        try
        {
            String urlAsString = 
                "file:///" 
                + new java.io.File(".").getCanonicalPath() 
                + "/" 
                + this.filePath;

            this.player = new AdvancedPlayer
            (
                new java.net.URL(urlAsString).openStream(),
                javazoom.jl.player.FactoryRegistry.systemRegistry().createAudioDevice()
            );

            this.player.setPlayBackListener(this);

            this.playerThread = new Thread(this, "AudioPlayerThread");

            this.playerThread.start();
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }

    // PlaybackListener members

    public void playbackStarted(PlaybackEvent playbackEvent)
    {
        System.out.println("playbackStarted()");
    }

    public void playbackFinished(PlaybackEvent playbackEvent)
    {
        System.out.println("playbackEnded()");
    }    

    // Runnable members

    public void run()
    {
        try
        {
            this.player.play();
        }
        catch (javazoom.jl.decoder.JavaLayerException ex)
        {
            ex.printStackTrace();
        }

    }
}