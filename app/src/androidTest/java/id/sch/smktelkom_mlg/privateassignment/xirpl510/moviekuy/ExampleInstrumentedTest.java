package id.sch.smktelkom_mlg.privateassignment.xirpl510.moviekuy;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() throws Exception {
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("id.sch.smktelkom_mlg.privateassignment.xirpl510.moviekuy", appContext.getPackageName());
    }
}
