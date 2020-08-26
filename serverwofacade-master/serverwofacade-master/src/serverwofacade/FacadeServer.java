package serverwofacade;

public class FacadeServer {
    static ScheduleServer scheduleServer = new ScheduleServer();
    private static FacadeServer facade = null;

    FacadeServer() {
    }

    public static FacadeServer getuserCommand() {

        if (facade == null) {
            facade = new FacadeServer();

        }
        return facade;
    }

    public static void Start() {
        scheduleServer.startBooting();
	    scheduleServer.readSystemConfigFile();
	    scheduleServer.init();
	    scheduleServer.initializeContext();
	    scheduleServer.initializeListeners();
	    scheduleServer.createSystemObjects();
    }

    public static void Stop(){
        scheduleServer.releaseProcesses();
	    scheduleServer.destory();
	    scheduleServer.destroySystemObjects();
	    scheduleServer.destoryListeners();
	    scheduleServer.destoryContext();
	    scheduleServer.shutdown();
    }

}