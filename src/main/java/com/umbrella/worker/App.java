package com.umbrella.worker;

import java.util.UUID;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println(System.currentTimeMillis() + UUID.randomUUID().hashCode() + "");
    }
}
