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

public class Chat {

    static Exchanger<String> exchanger = new Exchanger<>();

    public static void main(String args[]) {
        Thread customer = new Thread(new Customer(exchanger));
        Thread business = new Thread(new Business(exchanger));
        customer.start();
        business.start();
    }
}