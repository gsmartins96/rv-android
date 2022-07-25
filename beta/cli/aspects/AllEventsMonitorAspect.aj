import java.io.*;
import android.util.Log;
import android.media.MediaPlayer.OnPreparedListener;
import android.app.AlertDialog;
import android.app.Activity;
import android.content.DialogInterface;
import java.lang.*;
import java.util.concurrent.*;
import java.util.concurrent.locks.*;
import java.util.*;

import java.lang.ref.*;
import org.aspectj.lang.*;

aspect BaseAspect {
	pointcut notwithin() :
	!within(sun..*) &&
	!within(java..*) &&
	!within(javax..*) &&
	!within(com.sun..*) &&
	!within(org.dacapo.harness..*) &&
	!within(org.apache.commons..*) &&
	!within(org.apache.geronimo..*) &&
	!within(net.sf.cglib..*) &&
	!within(mop..*) &&
	!within(javamoprt..*) &&
	!within(rvmonitorrt..*) &&
	!within(com.runtimeverification..*);
}

public aspect AllEventsMonitorAspect implements com.runtimeverification.rvmonitor.java.rt.RVMObject {
	public AllEventsMonitorAspect(){
	}

	// Declarations for the Lock
	static ReentrantLock AllEvents_MOPLock = new ReentrantLock();
	static Condition AllEvents_MOPLock_cond = AllEvents_MOPLock.newCondition();

	pointcut AllEvents_allEvents(Object o) : (call(* Object+.*(..)) && target(o));
	after (Object o) : AllEvents_allEvents(o) {
		AllEventsRuntimeMonitor.allEventsEvent(o);
	}

}
