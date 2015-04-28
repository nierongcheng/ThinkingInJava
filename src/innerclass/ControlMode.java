package innerclass;

import java.util.ArrayList;

/**
 * @author  作者 E-mail: Codi, nierc@gionee.com
 * @date 创建时间: 2015年4月16日 上午9:08:59
 * @version 1.0 
 */
public class ControlMode {

    private abstract class Event {
        private long mEventTime;
        protected final long mDelayTime;
        
        public Event(long delayTime) {
            super();
            this.mDelayTime = delayTime;
        }
        
        public void start() {
            mEventTime = System.nanoTime() + mDelayTime;
            System.out.println("start--->" + System.nanoTime() + "  " + mEventTime);
        }
        
        public boolean ready() {
            System.out.println("ready--->" + System.nanoTime() + "  " + mEventTime);
            return System.nanoTime() > mEventTime;
        }
        
        public abstract void action();
    }
    
    public class Controller {
        ArrayList<Event> mEvents = new ArrayList<ControlMode.Event>();
        
        public void addEvent(Event event) {
            mEvents.add(event);
            event.start();
        }
        
        public void start() {
            while(true) {
                for(Event event : new ArrayList<Event>(mEvents)) {
                    if(event.ready()) {
                        event.action();
                        mEvents.remove(event);
                    }
                }
            }
        }
    }
    
    public class GreenController extends Controller {
        
        public boolean mLightOn = false;
        public boolean mWaterOn = false;
        
        public class LightOn extends Event {

            public LightOn(long delayTime) {
                super(delayTime);
            }

            @Override
            public void action() {
                mLightOn = true;
                System.out.println("light is on");
            }
        }
        
        public class LightOff extends Event {

            public LightOff(long delayTime) {
                super(delayTime);
            }

            @Override
            public void action() {
                mLightOn = true;
                System.out.println("light is off");
            }
        }
        
        public class WaterOn extends Event {

            public WaterOn(long delayTime) {
                super(delayTime);
            }

            @Override
            public void action() {
                mWaterOn = true;
                System.out.println("water is on");
            }
        }
        
        public class WaterOff extends Event {

            public WaterOff(long delayTime) {
                super(delayTime);
            }

            @Override
            public void action() {
                mWaterOn = true;
                System.out.println("water is off");
            }
        }
        
        public class Bell extends Event {

            public Bell(long delayTime) {
                super(delayTime);
            }

            @Override
            public void action() {
                System.out.println("bell is on");
//                addEvent(new Bell(mDelayTime));
            }
        }
        
        class Restart extends Event {
            
            private Event[] mEvents;

            public Restart(long delayTime, Event[] events) {
                super(delayTime);
                mEvents = events;
                for(Event event : mEvents) {
                    addEvent(event);
                }
            }

            @Override
            public void action() {
                for(Event event : mEvents) {
                    addEvent(event);
                }
                addEvent(this);
            }
        }
        
    }
    
    public static void main(String[] args) {
        ControlMode controlMode = new ControlMode();
        GreenController greenController = controlMode.new GreenController();
        Event bellEvent = greenController.new Bell(200000000);
        greenController.addEvent(bellEvent);
        greenController.start();
        
    }
}
