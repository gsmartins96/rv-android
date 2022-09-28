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

public aspect TelephonyManagerSpecMonitorAspect implements com.runtimeverification.rvmonitor.java.rt.RVMObject {
	public TelephonyManagerSpecMonitorAspect(){
	}

	// advices for Statistics
	after () : execution(* org.apache.maven.surefire.booter.ForkedBooter.runSuitesInProcess(..)) {
		System.err.println("==start TelephonyManagerSpec ==");
		System.err.println("#monitors: " + TelephonyManagerSpecMonitor.getTotalMonitorCount());
		System.err.println("#collected monitors: " + TelephonyManagerSpecMonitor.getCollectedMonitorCount());
		System.err.println("#terminated monitors: " + TelephonyManagerSpecMonitor.getTerminatedMonitorCount());
		System.err.println("#event - gi: " + TelephonyManagerSpecMonitor.getEventCounters().get("gi"));
		System.err.println("#event - gt: " + TelephonyManagerSpecMonitor.getEventCounters().get("gt"));
		System.err.println("#category - prop 1 - match: " + TelephonyManagerSpecMonitor.getCategoryCounters().get("match"));
		System.err.println("==end TelephonyManagerSpec ==");
	}
	// Declarations for the Lock
	static ReentrantLock TelephonyManagerSpec_MOPLock = new ReentrantLock();
	static Condition TelephonyManagerSpec_MOPLock_cond = TelephonyManagerSpec_MOPLock.newCondition();

	pointcut MOP_CommonPointCut() : !within(com.runtimeverification.rvmonitor.java.rt.RVMObject+) && !adviceexecution() && BaseAspect.notwithin();
	pointcut TelephonyManagerSpec_gi(TelephonyManager tm) : (call(public String android.telephony.TelephonyManager.getImei()) && target(tm)) && MOP_CommonPointCut();
	before (TelephonyManager tm) : TelephonyManagerSpec_gi(tm) {
		TelephonyManagerSpecRuntimeMonitor.TelephonyManagerSpec_giEvent(tm);
	}

	pointcut TelephonyManagerSpec_gt(TelephonyManager tm) : (call(public int android.telephony.TelephonyManager.getPhoneType()) && target(tm)) && MOP_CommonPointCut();
	before (TelephonyManager tm) : TelephonyManagerSpec_gt(tm) {
		TelephonyManagerSpecRuntimeMonitor.TelephonyManagerSpec_gtEvent(tm);
	}

}
