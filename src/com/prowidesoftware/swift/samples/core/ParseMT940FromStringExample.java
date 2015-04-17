/*
 * Copyright (c) http://www.prowidesoftware.com/, 2014. All rights reserved.
 */
package com.prowidesoftware.swift.samples.core;

import java.io.IOException;

import com.prowidesoftware.swift.model.field.Field20;
import com.prowidesoftware.swift.model.mt.mt9xx.MT940;

/**
 * This example shows how to read a SWIFT MT message from a file, in the context where
 * the message type to parse is already known, in the example we use an MT 103.
 * 
 * @author www.prowidesoftware.com
 * @since 7.7
 */
public class ParseMT940FromStringExample {

	public static void main(String[] args) throws IOException {
        /*
         * A simple String containing the message content to parse
         */
        String msg  = "{1:F01AAAABB99BSMK3513951576}"+
                "{2:O9400934081223BBBBAA33XXXX03592332770812230834N}" +
                "{4:\n"+
                ":20:0112230000000890\n"+
                ":25:SAKG800030155USD\n"+
                ":28C:255/1\n"+
                ":60F:C011223USD175768,92\n"+
                ":61:0112201223CD110,92NDIVNONREF//08 IL053309\n"+
                "/GB/2542049/SHS/312,\n"+
                ":62F:C011021USD175879,84\n"+
                ":20:NONREF\n" +
                ":25:4001400010\n" +
                ":28C:58/1\n" +
                ":60F:C140327EUR6308,75\n" +
                ":61:1403270327C3519,76NTRF50RS201403240008//2014032100037666\n" +
                "ABC DO BRASIL LTDA\n" +
                ":86:INVOICE NR. 6000012801 \n" +
                "ORDPRTY : ABC DO BRASIL LTDA RUA LIBERO BADARO,293-SAO \n" +
                "PAULO BRAZIL }";
        /*
		 * Parse the String content into a SWIFT message object
		 */
		MT940 mt = MT940.parse(msg);
		
		/*
		 * Print header information
		 */
		System.out.println("Sender: "+mt.getSender());
		System.out.println("Receiver: "+mt.getReceiver());
		
		/*
		 * Print details of a specific field
		 */
		Field20 f = mt.getField20();
		System.out.println("Field 20 Reference: "+f.getReference());
	}
}