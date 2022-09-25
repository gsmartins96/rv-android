package mop;
import java.security.Provider;
import java.security.MessageDigest;
import java.util.List;
import br.unb.cic.mop.eh.*;
import br.unb.cic.mop.ExecutionContext;
import br.unb.cic.mop.ExecutionContext.Property;
import android.util.Log;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import android.telephony.TelephonyManager;
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

public aspect LoggerMonitorAspect implements com.runtimeverification.rvmonitor.java.rt.RVMObject {
	public LoggerMonitorAspect(){
	}

	// advices for Statistics
	after () : execution(* org.apache.maven.surefire.booter.ForkedBooter.runSuitesInProcess(..)) {
		System.err.println("==start Logger ==");
		System.err.println("#monitors: " + LoggerMonitor.getTotalMonitorCount());
		System.err.println("#collected monitors: " + LoggerMonitor.getCollectedMonitorCount());
		System.err.println("#terminated monitors: " + LoggerMonitor.getTerminatedMonitorCount());
		System.err.println("#event - g1: " + LoggerMonitor.getEventCounters().get("g1"));
		System.err.println("#category - prop 1 - match: " + LoggerMonitor.getCategoryCounters().get("match"));
		System.err.println("==end Logger ==");
	}
	// Declarations for the Lock
	static ReentrantLock Logger_MOPLock = new ReentrantLock();
	static Condition Logger_MOPLock_cond = Logger_MOPLock.newCondition();

	pointcut MOP_CommonPointCut() : !within(com.runtimeverification.rvmonitor.java.rt.RVMObject+) && !adviceexecution() && BaseAspect.notwithin();
	pointcut Logger_g1(Object o) : (call(* Object+.*(..)) && target(o)) && MOP_CommonPointCut();
	after (Object o) : Logger_g1(o) {
		LoggerRuntimeMonitor.Logger_g1Event(o);
	}

}
