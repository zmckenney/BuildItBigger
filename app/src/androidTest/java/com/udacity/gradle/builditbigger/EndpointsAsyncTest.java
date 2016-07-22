package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.test.AndroidTestCase;

import org.mockito.Mock;

import java.util.concurrent.TimeUnit;

/**
 * Created by Zac on 7/21/16.
 *
 * I sued JeremyAtUdacity's post at the given link to work on this one
 * https://discussions.udacity.com/t/writing-tests-for-async-task/25482/10
 *
 * I also used part of this post as help as well
 * https://discussions.udacity.com/t/why-asynctask-test-is-failing/178626
 *
 */
public class EndpointsAsyncTest extends AndroidTestCase {

    @Mock Context mockContext;

    EndpointsAsyncTask task;
    String result;

    @Override
    protected void setUp() throws Exception {
        super.setUp();

        result = null;
        task = new EndpointsAsyncTask(){

            //Override the onPreExecute so we dont load the ProgressDialog and override the onPostExecute because we dont need the intent

            @Override
            protected void onPreExecute() {
            }

            @Override
            protected void onPostExecute(String joke){}
        };
    }
    public void testAsyncReturnType() {

        try{
            //Execute the asyncTask with mock context
            task.execute(mockContext);
            //No onPostExecute is ran so take the result of doInBackground
            result = task.get(10, TimeUnit.SECONDS);
            //Assert that our result is not a null variable
            assertNotNull(result);

        }catch (Exception e){
            //If our task.get is not successful within 10 seconds fail with "Timed out"
            fail("Timed out");
        }
    }
}