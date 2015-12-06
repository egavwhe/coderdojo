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

class Customer extends Person implements Runnable {
    Exchanger<String> exchanger;

    Customer(Exchanger<String> exchanger) {
        this.exchanger = exchanger;
    }

    @Override
    public void run() {
        receiveMessage(exchanger);
        sendMessage(exchanger, "I would like to buy a suit.");
        receiveMessage(exchanger);
    }

}