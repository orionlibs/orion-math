package io.github.orionlibs.orion_math;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.NotSerializableException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class CloningService
{
    public static Object clone(Object object)
    {
        ByteArrayOutputStream outputStream = null;
        ObjectOutputStream outputStream1 = null;
        ByteArrayInputStream inputStream = null;
        ObjectInputStream objInputStream = null;
        try
        {
            outputStream = new ByteArrayOutputStream();
            outputStream1 = new ObjectOutputStream(outputStream);
            outputStream1.writeObject(object);
            inputStream = new ByteArrayInputStream(outputStream.toByteArray());
            objInputStream = new ObjectInputStream(inputStream);
            return objInputStream.readObject();
        }
        catch(Exception e)
        {
            return null;
        }
        finally
        {
            releaseIOResources(inputStream, objInputStream, outputStream, outputStream1);
        }
    }


    public static Object cloneIgnoreUnserialisableException(Object object)
    {
        ByteArrayOutputStream outputStream = null;
        ObjectOutputStream outputStream1 = null;
        ByteArrayInputStream inputStream = null;
        ObjectInputStream objInputStream = null;
        try
        {
            outputStream = new ByteArrayOutputStream();
            outputStream1 = new ObjectOutputStream(outputStream);
            try
            {
                outputStream1.writeObject(object);
                inputStream = new ByteArrayInputStream(outputStream.toByteArray());
                objInputStream = new ObjectInputStream(inputStream);
                return objInputStream.readObject();
            }
            catch(NotSerializableException e)
            {
                return object;
            }
        }
        catch(Exception e)
        {
            return null;
        }
        finally
        {
            releaseIOResources(inputStream, objInputStream, outputStream, outputStream1);
        }
    }


    private static void releaseIOResources(ByteArrayInputStream a, ObjectInputStream b, ByteArrayOutputStream c, ObjectOutputStream d)
    {
        releaseIOResource(a);
        releaseIOResource(b);
        releaseIOResource(c);
        releaseIOResource(d);
    }


    private static void releaseIOResource(Closeable a)
    {
        if(a != null)
        {
            try
            {
                a.close();
            }
            catch(IOException e)
            {
                //throw new ResourceException("The resource cannot be closed.");
            }
        }
    }
}