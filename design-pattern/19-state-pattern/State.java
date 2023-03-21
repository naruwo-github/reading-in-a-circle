public interface State {
    public abstract void doClock(Context context, boolean isDay);

    public abstract void doUse(Context context);

    public abstract void doAlarm(Context context);

    public abstract void doPhone(Context context);
}