/*------------------------------------------------------------------------------
 *******************************************************************************
 * COPYRIGHT Ericsson 2013
 *
 * The copyright to the computer program(s) herein is the property of
 * Ericsson Inc. The programs may be used and/or copied only with written
 * permission from Ericsson Inc. or in accordance with the terms and
 * conditions stipulated in the agreement/contract under which the
 * program(s) have been supplied.
 *******************************************************************************
 *----------------------------------------------------------------------------*/
package com.exhange;

import java.util.concurrent.Exchanger;

class Person {

    void sendMessage(Exchanger<String> exchanger, String message) {
        try {
            exchanger.exchange(message);
        } catch (InterruptedException e) {
            System.err.println("Exchanging data failed.");
        }
    }

    void receiveMessage(Exchanger<String> exchanger) {
        String reply;
        try {
            reply = exchanger.exchange("");
            System.out.println(reply);
        } catch (InterruptedException e) {
            System.err.println("Exchanging data failed.");
        }
    }

}