package configure.injection;

import Service.DummyMeetingApiService;
import Service.MeetingApiService;

public class DI {
    private static final MeetingApiService service = new DummyMeetingApiService();



    public static MeetingApiService getMeetingApiService() {
        return service;

    }
   public static  MeetingApiService getNewInstanceApiService() {
        return new DummyMeetingApiService();
   }
}
