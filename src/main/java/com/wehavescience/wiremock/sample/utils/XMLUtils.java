package com.wehavescience.wiremock.sample.utils;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.io.StringWriter;

/**
 * @author Gabriel Francisco  <gabfssilva@gmail.com>
 */
public class XMLUtils {
    public static <T> T asObject(String xml, Class<T> clazz) {
        try {
            JAXBContext jaxbContext = null;
            jaxbContext = JAXBContext.newInstance(clazz);
            Unmarshaller unmarshaller = null;
            unmarshaller = jaxbContext.createUnmarshaller();
            return (T) unmarshaller.unmarshal(new StringReader(xml));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static <T> String asXml(T object) {
        try {
            JAXBContext jaxbContext = null;
            jaxbContext = JAXBContext.newInstance(object.getClass());
            Marshaller marshaller = jaxbContext.createMarshaller();
            StringWriter writer = new StringWriter();
            marshaller.marshal(object, writer);
            return writer.toString();
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }
}
