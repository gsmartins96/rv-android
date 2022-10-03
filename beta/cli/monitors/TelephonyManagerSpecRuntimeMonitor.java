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

final class TelephonyManagerSpecMonitor_Set extends com.runtimeverification.rvmonitor.java.rt.tablebase.AbstractMonitorSet<TelephonyManagerSpecMonitor> {

	TelephonyManagerSpecMonitor_Set(){
		this.size = 0;
		this.elements = new TelephonyManagerSpecMonitor[4];
	}
	final void event_gt(TelephonyManager tm) {
		int numAlive = 0 ;
		for(int i = 0; i < this.size; i++){
			TelephonyManagerSpecMonitor monitor = this.elements[i];
			if(!monitor.isTerminated()){
				elements[numAlive] = monitor;
				numAlive++;

				final TelephonyManagerSpecMonitor monitorfinalMonitor = monitor;
				monitor.Prop_1_event_gt(tm);
				if(monitorfinalMonitor.TelephonyManagerSpecMonitor_Prop_1_Category_match) {
					monitorfinalMonitor.Prop_1_handler_match();
				}
			}
		}
		for(int i = numAlive; i < this.size; i++){
			this.elements[i] = null;
		}
		size = numAlive;
	}
	final void event_gi(TelephonyManager tm) {
		int numAlive = 0 ;
		for(int i = 0; i < this.size; i++){
			TelephonyManagerSpecMonitor monitor = this.elements[i];
			if(!monitor.isTerminated()){
				elements[numAlive] = monitor;
				numAlive++;

				final TelephonyManagerSpecMonitor monitorfinalMonitor = monitor;
				monitor.Prop_1_event_gi(tm);
				if(monitorfinalMonitor.TelephonyManagerSpecMonitor_Prop_1_Category_match) {
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

class TelephonyManagerSpecMonitor extends com.runtimeverification.rvmonitor.java.rt.tablebase.AbstractAtomicMonitor implements Cloneable, com.runtimeverification.rvmonitor.java.rt.RVMObject {
	protected Object clone() {
		TelephonyManagerSpec_Monitor_num++;
		try {
			TelephonyManagerSpecMonitor ret = (TelephonyManagerSpecMonitor) super.clone();
			ret.pairValue = new AtomicInteger(pairValue.get());
			return ret;
		}
		catch (CloneNotSupportedException e) {
			throw new InternalError(e.toString());
		}
	}

	protected static long TelephonyManagerSpec_Monitor_num = 0;
	protected static long TelephonyManagerSpec_CollectedMonitor_num = 0;
	protected static long TelephonyManagerSpec_TerminatedMonitor_num = 0;
	protected static long TelephonyManagerSpec_gi_num = 0;
	protected static long TelephonyManagerSpec_gt_num = 0;
	protected static long TelephonyManagerSpec_1_match_num = 0;

	static final int Prop_1_transition_gt[] = {0, 1};;
	static final int Prop_1_transition_gi[] = {0, 1};;

	volatile boolean TelephonyManagerSpecMonitor_Prop_1_Category_match = false;

	private AtomicInteger pairValue;

	TelephonyManagerSpecMonitor() {
		this.pairValue = new AtomicInteger(this.calculatePairValue(-1, 0) ) ;

		TelephonyManagerSpec_Monitor_num++;
	}

	public static long getTotalMonitorCount() {
		return TelephonyManagerSpec_Monitor_num;
	}
	public static long getCollectedMonitorCount() {
		return TelephonyManagerSpec_CollectedMonitor_num;
	}
	public static long getTerminatedMonitorCount() {
		return TelephonyManagerSpec_TerminatedMonitor_num;
	}
	public static Map<String, Long> getEventCounters() {
		HashMap<String, Long> eventCounters = new HashMap<String, Long>();
		eventCounters.put("gi", TelephonyManagerSpec_gi_num);
		eventCounters.put("gt", TelephonyManagerSpec_gt_num);
		return eventCounters;
	}
	public static Map<String, Long> getCategoryCounters() {
		HashMap<String, Long> categoryCounters = new HashMap<String, Long>();
		categoryCounters.put("match", TelephonyManagerSpec_1_match_num);
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

	final boolean Prop_1_event_gt(TelephonyManager tm) {
		{
			Log.v("::::::::::::::::::::::::::::::::::::::::: RV-MONITOR: ", "Calling Object: ");
		}

		int nextstate = this.handleEvent(0, Prop_1_transition_gt) ;
		this.TelephonyManagerSpecMonitor_Prop_1_Category_match = nextstate == 0;

		return true;
	}

	final boolean Prop_1_event_gi(TelephonyManager tm) {
		{
			Log.v("::::::::::::::::::::::::::::::::::::::::: RV-MONITOR: ", "Calling Object: ");
		}

		int nextstate = this.handleEvent(1, Prop_1_transition_gi) ;
		this.TelephonyManagerSpecMonitor_Prop_1_Category_match = nextstate == 0;

		return true;
	}

	final void Prop_1_handler_match (){
		if(TelephonyManagerSpecMonitor_Prop_1_Category_match) {
			TelephonyManagerSpec_1_match_num++;
		}
		{
			Log.v("RV-ANDROID: ", "Metodo não permetido");
			throw new SandboxViolationException("TelephonyManager.getImei()");
		}

	}

	final void reset() {
		this.pairValue.set(this.calculatePairValue(-1, 0) ) ;

		TelephonyManagerSpecMonitor_Prop_1_Category_match = false;
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
			//gt
			return;
			case 1:
			//gi
			return;
		}
		return;
	}

	protected void finalize() throws Throwable {
		try {
			TelephonyManagerSpec_CollectedMonitor_num++;
		} finally {
			super.finalize();
		}
	}
	public static int getNumberOfEvents() {
		return 2;
	}

	public static int getNumberOfStates() {
		return 2;
	}

}

public final class TelephonyManagerSpecRuntimeMonitor implements com.runtimeverification.rvmonitor.java.rt.RVMObject {
	private static com.runtimeverification.rvmonitor.java.rt.map.RVMMapManager TelephonyManagerSpecMapManager;
	static {
		TelephonyManagerSpecMapManager = new com.runtimeverification.rvmonitor.java.rt.map.RVMMapManager();
		TelephonyManagerSpecMapManager.start();
	}

	// Declarations for the Lock
	static final ReentrantLock TelephonyManagerSpec_RVMLock = new ReentrantLock();
	static final Condition TelephonyManagerSpec_RVMLock_cond = TelephonyManagerSpec_RVMLock.newCondition();

	private static boolean TelephonyManagerSpec_activated = false;

	// Declarations for Indexing Trees
	private static final TelephonyManagerSpecMonitor TelephonyManagerSpec__Map = new TelephonyManagerSpecMonitor() ;

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

	public static final void TelephonyManagerSpec_gtEvent(TelephonyManager tm) {
		TelephonyManagerSpec_activated = true;
		while (!TelephonyManagerSpec_RVMLock.tryLock()) {
			Thread.yield();
		}

		TelephonyManagerSpecMonitor.TelephonyManagerSpec_gt_num++;

		TelephonyManagerSpecMonitor matchedEntry = null;
		{
			// FindOrCreateEntry
			matchedEntry = TelephonyManagerSpec__Map;
		}
		// D(X) main:1
		if ((matchedEntry == null) ) {
			// D(X) main:4
			TelephonyManagerSpecMonitor created = new TelephonyManagerSpecMonitor() ;
			matchedEntry = created;
		}
		// D(X) main:8--9
		final TelephonyManagerSpecMonitor matchedEntryfinalMonitor = matchedEntry;
		matchedEntry.Prop_1_event_gt(tm);
		if(matchedEntryfinalMonitor.TelephonyManagerSpecMonitor_Prop_1_Category_match) {
			matchedEntryfinalMonitor.Prop_1_handler_match();
		}

		TelephonyManagerSpec_RVMLock.unlock();
	}

	public static final void TelephonyManagerSpec_giEvent(TelephonyManager tm) {
		TelephonyManagerSpec_activated = true;
		while (!TelephonyManagerSpec_RVMLock.tryLock()) {
			Thread.yield();
		}

		TelephonyManagerSpecMonitor.TelephonyManagerSpec_gi_num++;

		TelephonyManagerSpecMonitor matchedEntry = null;
		{
			// FindOrCreateEntry
			matchedEntry = TelephonyManagerSpec__Map;
		}
		// D(X) main:1
		if ((matchedEntry == null) ) {
			// D(X) main:4
			TelephonyManagerSpecMonitor created = new TelephonyManagerSpecMonitor() ;
			matchedEntry = created;
		}
		// D(X) main:8--9
		final TelephonyManagerSpecMonitor matchedEntryfinalMonitor = matchedEntry;
		matchedEntry.Prop_1_event_gi(tm);
		if(matchedEntryfinalMonitor.TelephonyManagerSpecMonitor_Prop_1_Category_match) {
			matchedEntryfinalMonitor.Prop_1_handler_match();
		}

		TelephonyManagerSpec_RVMLock.unlock();
	}

}
