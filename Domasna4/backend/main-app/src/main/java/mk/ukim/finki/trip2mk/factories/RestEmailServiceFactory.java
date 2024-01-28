package mk.ukim.finki.trip2mk.factories;

import mk.ukim.finki.trip2mk.service.Impl.RestEmailServiceCommunicationImpl;

public class RestEmailServiceFactory {
    public static RestEmailServiceCommunicationImpl createInstance()
    {
        return new RestEmailServiceCommunicationImpl();
    }
}
