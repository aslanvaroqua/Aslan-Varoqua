package com.bluecompute.core

import org.springframework.http.converter.{HttpMessageNotWritableException, HttpMessageNotReadableException, AbstractHttpMessageConverter}
import org.springframework.http.{HttpInputMessage, HttpOutputMessage, MediaType}
import java.nio.charset.Charset
import com.lambdaworks.jacks.JacksMapper
import com.fasterxml.jackson.core.JsonParseException
import java.io._
import com.fasterxml.jackson.databind.SerializationFeature



class JacksMessageConverter extends AbstractHttpMessageConverter[Object](new MediaType("application", "json", Charset.forName("UTF-8"))) {

  val json = new JacksMapper
  {
    def canWrite(clazz: Class[_]) = mapper.canSerialize(clazz)

    def canDeserialize(clazz: Class[_]) =
      mapper.canDeserialize(mapper.constructType(clazz))

    def writeValue(value: Object,  out: OutputStream ) =
      mapper.writeValue(out,value);
  }


  override def readInternal(clazz: Class[_ <: Object],
                            inputMessage: HttpInputMessage) = {
    try {


      json.readValue(inputMessage.getBody)(Manifest.classType(clazz))
    } catch {
      case ex: JsonParseException =>
        throw new HttpMessageNotReadableException(
          "Could not read JSON: " + ex.getMessage(), ex);
    }
  }

  override def supports(clazz: Class[_]): Boolean = {
    throw new UnsupportedOperationException()
  }

  override def canRead(clazz: Class[_], mediaType: MediaType): Boolean = {
    json.canDeserialize(clazz) && canRead(mediaType)
  }

  override def canWrite(clazz: Class[_], medianType: MediaType): Boolean = {
    json.canWrite(clazz) && canWrite(medianType)
  }

  override def writeInternal(o: Object, outputMessage: HttpOutputMessage) = {
    try {
      json.mapper.configure(SerializationFeature.INDENT_OUTPUT, true)
      json.writeValue(o, outputMessage.getBody)
    } catch {
      case ex: Exception =>
        throw new HttpMessageNotWritableException(
          "Could not write JSON: " + ex.getMessage(), ex);
    }
  }
}

