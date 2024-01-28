package mk.ukim.finki.trip2mk.factories;

import mk.ukim.finki.trip2mk.service.Impl.RestEmailServiceCommunicationImpl;
import mk.ukim.finki.trip2mk.service.RestEmailServiceCommunication;

public class FactoryBean implements org.springframework.beans.factory.FactoryBean<RestEmailServiceCommunication> {
    @Override
    public RestEmailServiceCommunication getObject() throws Exception {
        return new RestEmailServiceCommunicationImpl();
    }

    @Override
    public Class<?> getObjectType() {
        return RestEmailServiceCommunication.class;
    }
}
