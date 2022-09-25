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
import com.runtimeverification.rvmonitor.java.rt.*;
import com.runtimeverification.rvmonitor.java.rt.ref.*;
import com.runtimeverification.rvmonitor.java.rt.table.*;
import com.runtimeverification.rvmonitor.java.rt.tablebase.AbstractIndexingTree;
import com.runtimeverification.rvmonitor.java.rt.tablebase.SetEventDelegator;
import com.runtimeverification.rvmonitor.java.rt.tablebase.TableAdopter.Tuple2;
import com.runtimeverification.rvmonitor.java.rt.tablebase.TableAdopter.Tuple3;
import com.runtimeverification.rvmonitor.java.rt.tablebase.IDisableHolder;
import com.runtimeverification.rvmonitor.java.rt.tablebase.IMonitor;
import com.runtimeverification.rvmonitor.java.rt.tablebase.DisableHolder;
import com.runtimeverification.rvmonitor.java.rt.tablebase.TerminatedMonitorCleaner;
import java.util.concurrent.atomic.AtomicInteger;

final class LoggerMonitor_Set extends com.runtimeverification.rvmonitor.java.rt.tablebase.AbstractMonitorSet<LoggerMonitor> {

	LoggerMonitor_Set(){
		this.size = 0;
		this.elements = new LoggerMonitor[4];
	}
	final void event_g1(Object o) {
		int numAlive = 0 ;
		for(int i = 0; i < this.size; i++){
			LoggerMonitor monitor = this.elements[i];
			if(!monitor.isTerminated()){
				elements[numAlive] = monitor;
				numAlive++;

				final LoggerMonitor monitorfinalMonitor = monitor;
				monitor.Prop_1_event_g1(o);
				if(monitorfinalMonitor.LoggerMonitor_Prop_1_Category_match) {
					monitorfinalMonitor.Prop_1_handler_match();
				}
			}
		}
		for(int i = numAlive; i < this.size; i++){
			this.elements[i] = null;
		}
		size = numAlive;
	}
}

class LoggerMonitor extends com.runtimeverification.rvmonitor.java.rt.tablebase.AbstractAtomicMonitor implements Cloneable, com.runtimeverification.rvmonitor.java.rt.RVMObject {
	protected Object clone() {
		Logger_Monitor_num++;
		try {
			LoggerMonitor ret = (LoggerMonitor) super.clone();
			ret.pairValue = new AtomicInteger(pairValue.get());
			return ret;
		}
		catch (CloneNotSupportedException e) {
			throw new InternalError(e.toString());
		}
	}

	protected static long Logger_Monitor_num = 0;
	protected static long Logger_CollectedMonitor_num = 0;
	protected static long Logger_TerminatedMonitor_num = 0;
	protected static long Logger_g1_num = 0;
	protected static long Logger_1_match_num = 0;

	static final int Prop_1_transition_g1[] = {0, 1};;

	volatile boolean LoggerMonitor_Prop_1_Category_match = false;

	private AtomicInteger pairValue;

	LoggerMonitor() {
		this.pairValue = new AtomicInteger(this.calculatePairValue(-1, 0) ) ;

		Logger_Monitor_num++;
	}

	public static long getTotalMonitorCount() {
		return Logger_Monitor_num;
	}
	public static long getCollectedMonitorCount() {
		return Logger_CollectedMonitor_num;
	}
	public static long getTerminatedMonitorCount() {
		return Logger_TerminatedMonitor_num;
	}
	public static Map<String, Long> getEventCounters() {
		HashMap<String, Long> eventCounters = new HashMap<String, Long>();
		eventCounters.put("g1", Logger_g1_num);
		return eventCounters;
	}
	public static Map<String, Long> getCategoryCounters() {
		HashMap<String, Long> categoryCounters = new HashMap<String, Long>();
		categoryCounters.put("match", Logger_1_match_num);
		return categoryCounters;
	}

	@Override public final int getState() {
		return this.getState(this.pairValue.get() ) ;
	}
	@Override public final int getLastEvent() {
		return this.getLastEvent(this.pairValue.get() ) ;
	}
	private final int getState(int pairValue) {
		return (pairValue & 1) ;
	}
	private final int getLastEvent(int pairValue) {
		return (pairValue >> 1) ;
	}
	private final int calculatePairValue(int lastEvent, int state) {
		return (((lastEvent + 1) << 1) | state) ;
	}

	private final int handleEvent(int eventId, int[] table) {
		int nextstate;
		while (true) {
			int oldpairvalue = this.pairValue.get() ;
			int oldstate = this.getState(oldpairvalue) ;
			nextstate = table [ oldstate ];
			int nextpairvalue = this.calculatePairValue(eventId, nextstate) ;
			if (this.pairValue.compareAndSet(oldpairvalue, nextpairvalue) ) {
				break;
			}
		}
		return nextstate;
	}

	final boolean Prop_1_event_g1(Object o) {
		{
			Log.v("::::::::::::::::::::::::::::::::::::::::: RV-MONITOR: ", "Calling Object: " + o.getClass());
		}

		int nextstate = this.handleEvent(0, Prop_1_transition_g1) ;
		this.LoggerMonitor_Prop_1_Category_match = nextstate == 0;

		return true;
	}

	final void Prop_1_handler_match (){
		if(LoggerMonitor_Prop_1_Category_match) {
			Logger_1_match_num++;
		}
		{
			Log.v("JavaMOP: ", "match: Evento g1 realizado");
		}

	}

	final void reset() {
		this.pairValue.set(this.calculatePairValue(-1, 0) ) ;

		LoggerMonitor_Prop_1_Category_match = false;
	}

	@Override
	protected final void terminateInternal(int idnum) {
		int lastEvent = this.getLastEvent();

		switch(idnum){
		}
		switch(lastEvent) {
			case -1:
			return;
			case 0:
			//g1
			return;
		}
		return;
	}

	protected void finalize() throws Throwable {
		try {
			Logger_CollectedMonitor_num++;
		} finally {
			super.finalize();
		}
	}
	public static int getNumberOfEvents() {
		return 1;
	}

	public static int getNumberOfStates() {
		return 2;
	}

}

public final class LoggerRuntimeMonitor implements com.runtimeverification.rvmonitor.java.rt.RVMObject {
	private static com.runtimeverification.rvmonitor.java.rt.map.RVMMapManager LoggerMapManager;
	static {
		LoggerMapManager = new com.runtimeverification.rvmonitor.java.rt.map.RVMMapManager();
		LoggerMapManager.start();
	}

	// Declarations for the Lock
	static final ReentrantLock Logger_RVMLock = new ReentrantLock();
	static final Condition Logger_RVMLock_cond = Logger_RVMLock.newCondition();

	private static boolean Logger_activated = false;

	// Declarations for Indexing Trees
	private static final LoggerMonitor Logger__Map = new LoggerMonitor() ;

	public static int cleanUp() {
		int collected = 0;
		// indexing trees
		return collected;
	}

	// Removing terminated monitors from partitioned sets
	static {
		TerminatedMonitorCleaner.start() ;
	}
	// Setting the behavior of the runtime library according to the compile-time option
	static {
		RuntimeOption.enableFineGrainedLock(false) ;
	}

	public static final void Logger_g1Event(Object o) {
		Logger_activated = true;
		while (!Logger_RVMLock.tryLock()) {
			Thread.yield();
		}

		LoggerMonitor.Logger_g1_num++;

		LoggerMonitor matchedEntry = null;
		{
			// FindOrCreateEntry
			matchedEntry = Logger__Map;
		}
		// D(X) main:1
		if ((matchedEntry == null) ) {
			// D(X) main:4
			LoggerMonitor created = new LoggerMonitor() ;
			matchedEntry = created;
		}
		// D(X) main:8--9
		final LoggerMonitor matchedEntryfinalMonitor = matchedEntry;
		matchedEntry.Prop_1_event_g1(o);
		if(matchedEntryfinalMonitor.LoggerMonitor_Prop_1_Category_match) {
			matchedEntryfinalMonitor.Prop_1_handler_match();
		}

		Logger_RVMLock.unlock();
	}

}
