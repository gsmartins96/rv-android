
import java.io.*;
import android.util.Log;
import android.media.MediaPlayer.OnPreparedListener;
import android.app.AlertDialog;
import android.app.Activity;
import android.content.DialogInterface;
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

final class Closeable_MultipleCloseMonitor_Set extends com.runtimeverification.rvmonitor.java.rt.tablebase.AbstractMonitorSet<Closeable_MultipleCloseMonitor> {
	boolean skipEvent = false;

	Closeable_MultipleCloseMonitor_Set(){
		this.size = 0;
		this.elements = new Closeable_MultipleCloseMonitor[4];
	}
	final void event_close(Closeable c) {
		int numAlive = 0 ;
		for(int i = 0; i < this.size; i++){
			Closeable_MultipleCloseMonitor monitor = this.elements[i];
			if(!monitor.isTerminated()){
				elements[numAlive] = monitor;
				numAlive++;

				final Closeable_MultipleCloseMonitor monitorfinalMonitor = monitor;
				monitor.Prop_1_event_close(c);
				if(monitorfinalMonitor.Closeable_MultipleCloseMonitor_Prop_1_Category_match) {
					monitorfinalMonitor.Prop_1_handler_match();
				}
				skipEvent |= monitorfinalMonitor.skipEvent;
				monitorfinalMonitor.skipEvent = false;
			}
		}
		for(int i = numAlive; i < this.size; i++){
			this.elements[i] = null;
		}
		size = numAlive;
	}
}
final class GetSystemServiceMonitor_Set extends com.runtimeverification.rvmonitor.java.rt.tablebase.AbstractMonitorSet<GetSystemServiceMonitor> {

	GetSystemServiceMonitor_Set(){
		this.size = 0;
		this.elements = new GetSystemServiceMonitor[4];
	}
	final void event_getLocationService() {
		int numAlive = 0 ;
		for(int i = 0; i < this.size; i++){
			GetSystemServiceMonitor monitor = this.elements[i];
			if(!monitor.isTerminated()){
				elements[numAlive] = monitor;
				numAlive++;

				final GetSystemServiceMonitor monitorfinalMonitor = monitor;
				monitor.Prop_1_event_getLocationService();
				if(monitorfinalMonitor.GetSystemServiceMonitor_Prop_1_Category_match) {
					monitorfinalMonitor.Prop_1_handler_match();
				}
			}
		}
		for(int i = numAlive; i < this.size; i++){
			this.elements[i] = null;
		}
		size = numAlive;
	}
	final void event_getTextService() {
		int numAlive = 0 ;
		for(int i = 0; i < this.size; i++){
			GetSystemServiceMonitor monitor = this.elements[i];
			if(!monitor.isTerminated()){
				elements[numAlive] = monitor;
				numAlive++;

				final GetSystemServiceMonitor monitorfinalMonitor = monitor;
				monitor.Prop_1_event_getTextService();
				if(monitorfinalMonitor.GetSystemServiceMonitor_Prop_1_Category_match) {
					monitorfinalMonitor.Prop_1_handler_match();
				}
			}
		}
		for(int i = numAlive; i < this.size; i++){
			this.elements[i] = null;
		}
		size = numAlive;
	}
	final void event_getTelephonyService() {
		int numAlive = 0 ;
		for(int i = 0; i < this.size; i++){
			GetSystemServiceMonitor monitor = this.elements[i];
			if(!monitor.isTerminated()){
				elements[numAlive] = monitor;
				numAlive++;

				final GetSystemServiceMonitor monitorfinalMonitor = monitor;
				monitor.Prop_1_event_getTelephonyService();
				if(monitorfinalMonitor.GetSystemServiceMonitor_Prop_1_Category_match) {
					monitorfinalMonitor.Prop_1_handler_match();
				}
			}
		}
		for(int i = numAlive; i < this.size; i++){
			this.elements[i] = null;
		}
		size = numAlive;
	}
	final void event_getNotificationService() {
		int numAlive = 0 ;
		for(int i = 0; i < this.size; i++){
			GetSystemServiceMonitor monitor = this.elements[i];
			if(!monitor.isTerminated()){
				elements[numAlive] = monitor;
				numAlive++;

				final GetSystemServiceMonitor monitorfinalMonitor = monitor;
				monitor.Prop_1_event_getNotificationService();
				if(monitorfinalMonitor.GetSystemServiceMonitor_Prop_1_Category_match) {
					monitorfinalMonitor.Prop_1_handler_match();
				}
			}
		}
		for(int i = numAlive; i < this.size; i++){
			this.elements[i] = null;
		}
		size = numAlive;
	}
	final void event_getStorageService() {
		int numAlive = 0 ;
		for(int i = 0; i < this.size; i++){
			GetSystemServiceMonitor monitor = this.elements[i];
			if(!monitor.isTerminated()){
				elements[numAlive] = monitor;
				numAlive++;

				final GetSystemServiceMonitor monitorfinalMonitor = monitor;
				monitor.Prop_1_event_getStorageService();
				if(monitorfinalMonitor.GetSystemServiceMonitor_Prop_1_Category_match) {
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

class Closeable_MultipleCloseMonitor extends com.runtimeverification.rvmonitor.java.rt.tablebase.AbstractAtomicMonitor implements Cloneable, com.runtimeverification.rvmonitor.java.rt.RVMObject {
	protected Object clone() {
		try {
			Closeable_MultipleCloseMonitor ret = (Closeable_MultipleCloseMonitor) super.clone();
			ret.pairValue = new AtomicInteger(pairValue.get());
			return ret;
		}
		catch (CloneNotSupportedException e) {
			throw new InternalError(e.toString());
		}
	}

	boolean skipEvent = false;

	static final int Prop_1_transition_close[] = {2, 1, 1, 3};;

	volatile boolean Closeable_MultipleCloseMonitor_Prop_1_Category_match = false;

	private AtomicInteger pairValue;

	Closeable_MultipleCloseMonitor() {
		this.pairValue = new AtomicInteger(this.calculatePairValue(-1, 0));

	}

	@Override public final int getState() {
		return this.getState(this.pairValue.get());
	}
	@Override public final int getLastEvent() {
		return this.getLastEvent(this.pairValue.get());
	}
	private final int getState(int pairValue) {
		return (pairValue & 3);
	}
	private final int getLastEvent(int pairValue) {
		return (pairValue >> 2);
	}
	private final int calculatePairValue(int lastEvent, int state) {
		return (((lastEvent + 1)<< 2)| state);
	}

	private final int handleEvent(int eventId, int[] table) {
		int nextstate;
		while (true) {
			int oldpairvalue = this.pairValue.get();
			int oldstate = this.getState(oldpairvalue);
			nextstate = table [ oldstate ];
			int nextpairvalue = this.calculatePairValue(eventId, nextstate);
			if (this.pairValue.compareAndSet(oldpairvalue, nextpairvalue)) {
				break;
			}
		}
		return nextstate;
	}

	final boolean Prop_1_event_close(Closeable c) {
		{
			Log.v("RV-MONITOR", "Closeable stream closed! Hashcode " + c.hashCode() + ", class: " + c.getClass());
		}

		int nextstate = this.handleEvent(0, Prop_1_transition_close);
		this.Closeable_MultipleCloseMonitor_Prop_1_Category_match = nextstate == 1;

		return true;
	}

	final void Prop_1_handler_match (){
		{
			Log.v("RV-MONITOR", "Severe: Multiple close detected.  Recovering.");
			skipEvent = true;
		}

	}

	final void reset() {
		this.pairValue.set(this.calculatePairValue(-1, 0));

		Closeable_MultipleCloseMonitor_Prop_1_Category_match = false;
	}

	// RVMRef_c was suppressed to reduce memory overhead

	//alive_parameters_0 = [Closeable c]
	boolean alive_parameters_0 = true;

	@Override
	protected final void terminateInternal(int idnum) {
		int lastEvent = this.getLastEvent();

		switch(idnum){
			case 0:
			alive_parameters_0 = false;
			break;
		}
		switch(lastEvent) {
			case -1:
			return;
			case 0:
			//close
			//alive_c
			if(!(alive_parameters_0)){
				RVM_terminated = true;
				return;
			}
			break;

		}
		return;
	}

	public static int getNumberOfEvents() {
		return 1;
	}

	public static int getNumberOfStates() {
		return 4;
	}

}
interface IGetSystemServiceMonitor extends IMonitor, IDisableHolder {
}

class GetSystemServiceDisableHolder extends DisableHolder implements IGetSystemServiceMonitor {
	GetSystemServiceDisableHolder(long tau) {
		super(tau);
	}

	@Override
	public final boolean isTerminated() {
		return false;
	}

	@Override
	public int getLastEvent() {
		return -1;
	}

	@Override
	public int getState() {
		return -1;
	}

}

class GetSystemServiceMonitor extends com.runtimeverification.rvmonitor.java.rt.tablebase.AbstractSynchronizedMonitor implements Cloneable, com.runtimeverification.rvmonitor.java.rt.RVMObject, IGetSystemServiceMonitor {
	protected Object clone() {
		try {
			GetSystemServiceMonitor ret = (GetSystemServiceMonitor) super.clone();
			return ret;
		}
		catch (CloneNotSupportedException e) {
			throw new InternalError(e.toString());
		}
	}

	static android.app.Activity RVM_activity;
	static void setActivity(android.app.Activity a) {
		RVM_activity = a;
	}

	WeakReference Ref_x = null;
	int Prop_1_state;
	static final int Prop_1_transition_getLocationService[] = {2, 3, 2, 3};;
	static final int Prop_1_transition_getTextService[] = {2, 3, 2, 3};;
	static final int Prop_1_transition_getTelephonyService[] = {2, 3, 2, 3};;
	static final int Prop_1_transition_getNotificationService[] = {3, 3, 3, 3};;
	static final int Prop_1_transition_getStorageService[] = {3, 3, 1, 3};;

	boolean GetSystemServiceMonitor_Prop_1_Category_match = false;

	GetSystemServiceMonitor(long tau) {
		this.tau = tau;
		Prop_1_state = 0;

	}

	@Override
	public final int getState() {
		return Prop_1_state;
	}

	private final long tau;
	private long disable = -1;

	@Override
	public final long getTau() {
		return this.tau;
	}

	@Override
	public final long getDisable() {
		return this.disable;
	}

	@Override
	public final void setDisable(long value) {
		this.disable = value;
	}

	final boolean Prop_1_event_getLocationService() {
		Integer x = null;
		if(Ref_x != null){
			x = (Integer)Ref_x.get();
		}
		{
			Log.v("RV-MONITOR", "App is grabbing location service!");
		}
		RVM_lastevent = 0;

		Prop_1_state = Prop_1_transition_getLocationService[Prop_1_state];
		GetSystemServiceMonitor_Prop_1_Category_match = Prop_1_state == 1;
		return true;
	}

	final boolean Prop_1_event_getTextService() {
		Integer x = null;
		if(Ref_x != null){
			x = (Integer)Ref_x.get();
		}
		{
			Log.v("RV-MONITOR", "App is grabbing SMS service!");
		}
		RVM_lastevent = 1;

		Prop_1_state = Prop_1_transition_getTextService[Prop_1_state];
		GetSystemServiceMonitor_Prop_1_Category_match = Prop_1_state == 1;
		return true;
	}

	final boolean Prop_1_event_getTelephonyService() {
		Integer x = null;
		if(Ref_x != null){
			x = (Integer)Ref_x.get();
		}
		{
			Log.v("RV-MONITOR", "App is grabbing telephony service!");
		}
		RVM_lastevent = 2;

		Prop_1_state = Prop_1_transition_getTelephonyService[Prop_1_state];
		GetSystemServiceMonitor_Prop_1_Category_match = Prop_1_state == 1;
		return true;
	}

	final boolean Prop_1_event_getNotificationService() {
		Integer x = null;
		if(Ref_x != null){
			x = (Integer)Ref_x.get();
		}
		{
			Log.v("RV-MONITOR", "App is grabbing notification service!");
		}
		RVM_lastevent = 3;

		Prop_1_state = Prop_1_transition_getNotificationService[Prop_1_state];
		GetSystemServiceMonitor_Prop_1_Category_match = Prop_1_state == 1;
		return true;
	}

	final boolean Prop_1_event_getStorageService() {
		Integer x = null;
		if(Ref_x != null){
			x = (Integer)Ref_x.get();
		}
		{
			Log.v("RV-MONITOR", "App is grabbing storage service!");
		}
		RVM_lastevent = 4;

		Prop_1_state = Prop_1_transition_getStorageService[Prop_1_state];
		GetSystemServiceMonitor_Prop_1_Category_match = Prop_1_state == 1;
		return true;
	}

	final void Prop_1_handler_match (){
		{
			Log.v("RV-MONITOR", "Possible data exfiltration risk! Storage service accessed after telephony, location, or text service.");
			if (this.RVM_activity != null) {
				AlertDialog.Builder builder = new AlertDialog.Builder(this.RVM_activity);
				builder.setMessage("Possible data exfiltration event: storage service accessed by application after telephony, SMS, or location.");
				builder.setPositiveButton("Ok",new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int id) {}
					});
					builder.create().show();
				}
			}

		}

		final void reset() {
			RVM_lastevent = -1;
			Prop_1_state = 0;
			GetSystemServiceMonitor_Prop_1_Category_match = false;
		}

		// RVMRef_x was suppressed to reduce memory overhead

		@Override
		protected final void terminateInternal(int idnum) {
			switch(idnum){
				case 0:
				break;
			}
			switch(RVM_lastevent) {
				case -1:
				return;
				case 0:
				//getLocationService
				return;
				case 1:
				//getTextService
				return;
				case 2:
				//getTelephonyService
				return;
				case 3:
				//getNotificationService
				return;
				case 4:
				//getStorageService
				return;
			}
			return;
		}

		public static int getNumberOfEvents() {
			return 5;
		}

		public static int getNumberOfStates() {
			return 4;
		}

	}

	public final class MultiSpec_1RuntimeMonitor implements com.runtimeverification.rvmonitor.java.rt.RVMObject {
		public static boolean skipEvent = false;
		private static com.runtimeverification.rvmonitor.java.rt.map.RVMMapManager MultiSpec_1MapManager;
		static {
			MultiSpec_1MapManager = new com.runtimeverification.rvmonitor.java.rt.map.RVMMapManager();
			MultiSpec_1MapManager.start();
		}

		// Declarations for the Lock
		static final ReentrantLock MultiSpec_1_RVMLock = new ReentrantLock();
		static final Condition MultiSpec_1_RVMLock_cond = MultiSpec_1_RVMLock.newCondition();

		// Declarations for Timestamps
		private static long GetSystemService_timestamp = 1;

		private static boolean Closeable_MultipleClose_activated = false;
		private static boolean GetSystemService_activated = false;

		// Declarations for Indexing Trees
		private static Object Closeable_MultipleClose_c_Map_cachekey_c;
		private static Closeable_MultipleCloseMonitor Closeable_MultipleClose_c_Map_cachevalue;
		private static final MapOfMonitor<Closeable_MultipleCloseMonitor> Closeable_MultipleClose_c_Map = new MapOfMonitor<Closeable_MultipleCloseMonitor>(0);

		private static final Tuple2<GetSystemServiceMonitor_Set, GetSystemServiceMonitor> GetSystemService__Map = new Tuple2<GetSystemServiceMonitor_Set, GetSystemServiceMonitor>(new GetSystemServiceMonitor_Set(), null);

		public static int cleanUp() {
			int collected = 0;
			// indexing trees
			collected += Closeable_MultipleClose_c_Map.cleanUpUnnecessaryMappings();
			return collected;
		}

		// Removing terminated monitors from partitioned sets
		static {
			TerminatedMonitorCleaner.start();
		}
		// Setting the behavior of the runtime library according to the compile-time option
		static {
			RuntimeOption.enableFineGrainedLock(false);
		}

		public static final void Closeable_MultipleClose_closeEvent(Closeable c) {
			Closeable_MultipleClose_activated = true;
			while (!MultiSpec_1_RVMLock.tryLock()) {
				Thread.yield();
			}

			CachedWeakReference wr_c = null;
			MapOfMonitor<Closeable_MultipleCloseMonitor> matchedLastMap = null;
			Closeable_MultipleCloseMonitor matchedEntry = null;
			boolean cachehit = false;
			if ((c == Closeable_MultipleClose_c_Map_cachekey_c)) {
				matchedEntry = Closeable_MultipleClose_c_Map_cachevalue;
				cachehit = true;
			}
			else {
				wr_c = new CachedWeakReference(c);
				{
					// FindOrCreateEntry
					MapOfMonitor<Closeable_MultipleCloseMonitor> itmdMap = Closeable_MultipleClose_c_Map;
					matchedLastMap = itmdMap;
					Closeable_MultipleCloseMonitor node_c = Closeable_MultipleClose_c_Map.getNodeEquivalent(wr_c);
					matchedEntry = node_c;
				}
			}
			// D(X) main:1
			if ((matchedEntry == null)) {
				if ((wr_c == null)) {
					wr_c = new CachedWeakReference(c);
				}
				// D(X) main:4
				Closeable_MultipleCloseMonitor created = new Closeable_MultipleCloseMonitor();
				matchedEntry = created;
				matchedLastMap.putNode(wr_c, created);
			}
			// D(X) main:8--9
			final Closeable_MultipleCloseMonitor matchedEntryfinalMonitor = matchedEntry;
			matchedEntry.Prop_1_event_close(c);
			if(matchedEntryfinalMonitor.Closeable_MultipleCloseMonitor_Prop_1_Category_match) {
				matchedEntryfinalMonitor.Prop_1_handler_match();
			}
			skipEvent |= matchedEntryfinalMonitor.skipEvent;
			matchedEntryfinalMonitor.skipEvent = false;

			if ((cachehit == false)) {
				Closeable_MultipleClose_c_Map_cachekey_c = c;
				Closeable_MultipleClose_c_Map_cachevalue = matchedEntry;
			}

			MultiSpec_1_RVMLock.unlock();
		}

		public static final void GetSystemService_getLocationServiceEvent() {
			GetSystemService_activated = true;
			while (!MultiSpec_1_RVMLock.tryLock()) {
				Thread.yield();
			}

			Tuple2<GetSystemServiceMonitor_Set, GetSystemServiceMonitor> matchedEntry = null;
			{
				// FindOrCreateEntry
				matchedEntry = GetSystemService__Map;
			}
			// D(X) main:1
			GetSystemServiceMonitor matchedLeaf = matchedEntry.getValue2();
			if ((matchedLeaf == null)) {
				if ((matchedLeaf == null)) {
					// D(X) main:4
					GetSystemServiceMonitor created = new GetSystemServiceMonitor(GetSystemService_timestamp++);
					matchedEntry.setValue2(created);
					GetSystemServiceMonitor_Set enclosingSet = matchedEntry.getValue1();
					enclosingSet.add(created);
				}
				// D(X) main:6
				GetSystemServiceMonitor disableUpdatedLeaf = matchedEntry.getValue2();
				disableUpdatedLeaf.setDisable(GetSystemService_timestamp++);
			}
			// D(X) main:8--9
			GetSystemServiceMonitor_Set stateTransitionedSet = matchedEntry.getValue1();
			stateTransitionedSet.event_getLocationService();

			MultiSpec_1_RVMLock.unlock();
		}

		public static final void GetSystemService_getTextServiceEvent() {
			GetSystemService_activated = true;
			while (!MultiSpec_1_RVMLock.tryLock()) {
				Thread.yield();
			}

			Tuple2<GetSystemServiceMonitor_Set, GetSystemServiceMonitor> matchedEntry = null;
			{
				// FindOrCreateEntry
				matchedEntry = GetSystemService__Map;
			}
			// D(X) main:1
			GetSystemServiceMonitor matchedLeaf = matchedEntry.getValue2();
			if ((matchedLeaf == null)) {
				if ((matchedLeaf == null)) {
					// D(X) main:4
					GetSystemServiceMonitor created = new GetSystemServiceMonitor(GetSystemService_timestamp++);
					matchedEntry.setValue2(created);
					GetSystemServiceMonitor_Set enclosingSet = matchedEntry.getValue1();
					enclosingSet.add(created);
				}
				// D(X) main:6
				GetSystemServiceMonitor disableUpdatedLeaf = matchedEntry.getValue2();
				disableUpdatedLeaf.setDisable(GetSystemService_timestamp++);
			}
			// D(X) main:8--9
			GetSystemServiceMonitor_Set stateTransitionedSet = matchedEntry.getValue1();
			stateTransitionedSet.event_getTextService();

			MultiSpec_1_RVMLock.unlock();
		}

		public static final void GetSystemService_getTelephonyServiceEvent() {
			GetSystemService_activated = true;
			while (!MultiSpec_1_RVMLock.tryLock()) {
				Thread.yield();
			}

			Tuple2<GetSystemServiceMonitor_Set, GetSystemServiceMonitor> matchedEntry = null;
			{
				// FindOrCreateEntry
				matchedEntry = GetSystemService__Map;
			}
			// D(X) main:1
			GetSystemServiceMonitor matchedLeaf = matchedEntry.getValue2();
			if ((matchedLeaf == null)) {
				if ((matchedLeaf == null)) {
					// D(X) main:4
					GetSystemServiceMonitor created = new GetSystemServiceMonitor(GetSystemService_timestamp++);
					matchedEntry.setValue2(created);
					GetSystemServiceMonitor_Set enclosingSet = matchedEntry.getValue1();
					enclosingSet.add(created);
				}
				// D(X) main:6
				GetSystemServiceMonitor disableUpdatedLeaf = matchedEntry.getValue2();
				disableUpdatedLeaf.setDisable(GetSystemService_timestamp++);
			}
			// D(X) main:8--9
			GetSystemServiceMonitor_Set stateTransitionedSet = matchedEntry.getValue1();
			stateTransitionedSet.event_getTelephonyService();

			MultiSpec_1_RVMLock.unlock();
		}

		public static final void GetSystemService_getNotificationServiceEvent() {
			GetSystemService_activated = true;
			while (!MultiSpec_1_RVMLock.tryLock()) {
				Thread.yield();
			}

			Tuple2<GetSystemServiceMonitor_Set, GetSystemServiceMonitor> matchedEntry = null;
			{
				// FindOrCreateEntry
				matchedEntry = GetSystemService__Map;
			}
			// D(X) main:1
			GetSystemServiceMonitor matchedLeaf = matchedEntry.getValue2();
			if ((matchedLeaf == null)) {
				if ((matchedLeaf == null)) {
					// D(X) main:4
					GetSystemServiceMonitor created = new GetSystemServiceMonitor(GetSystemService_timestamp++);
					matchedEntry.setValue2(created);
					GetSystemServiceMonitor_Set enclosingSet = matchedEntry.getValue1();
					enclosingSet.add(created);
				}
				// D(X) main:6
				GetSystemServiceMonitor disableUpdatedLeaf = matchedEntry.getValue2();
				disableUpdatedLeaf.setDisable(GetSystemService_timestamp++);
			}
			// D(X) main:8--9
			GetSystemServiceMonitor_Set stateTransitionedSet = matchedEntry.getValue1();
			stateTransitionedSet.event_getNotificationService();

			MultiSpec_1_RVMLock.unlock();
		}

		public static final void GetSystemService_getStorageServiceEvent() {
			GetSystemService_activated = true;
			while (!MultiSpec_1_RVMLock.tryLock()) {
				Thread.yield();
			}

			Tuple2<GetSystemServiceMonitor_Set, GetSystemServiceMonitor> matchedEntry = null;
			{
				// FindOrCreateEntry
				matchedEntry = GetSystemService__Map;
			}
			// D(X) main:1
			GetSystemServiceMonitor matchedLeaf = matchedEntry.getValue2();
			if ((matchedLeaf == null)) {
				if ((matchedLeaf == null)) {
					// D(X) main:4
					GetSystemServiceMonitor created = new GetSystemServiceMonitor(GetSystemService_timestamp++);
					matchedEntry.setValue2(created);
					GetSystemServiceMonitor_Set enclosingSet = matchedEntry.getValue1();
					enclosingSet.add(created);
				}
				// D(X) main:6
				GetSystemServiceMonitor disableUpdatedLeaf = matchedEntry.getValue2();
				disableUpdatedLeaf.setDisable(GetSystemService_timestamp++);
			}
			// D(X) main:8--9
			GetSystemServiceMonitor_Set stateTransitionedSet = matchedEntry.getValue1();
			stateTransitionedSet.event_getStorageService();

			MultiSpec_1_RVMLock.unlock();
		}

		public static void onCreateActivity(Activity a) {
			GetSystemServiceMonitor.RVM_activity = a;
		}

	}
