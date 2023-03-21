import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;

public class SafeFrame extends Frame implements Context {
    private TextField textClock = new TextField(60);
    private TextArea textScreen = new TextArea(10, 60);
    private Button buttonUse = new Button("金庫使用");
    private Button buttonAlarm = new Button("非常ベル");
    private Button buttonPhone = new Button("通常通話");
    private Button buttonExit = new Button("終了");

    private State state = DayState.getInstance();

    public SafeFrame(String title) {
        super(title);
        setBackground(Color.lightGray);
        setLayout(new BorderLayout());
        add(textClock, BorderLayout.NORTH);
        this.textClock.setEditable(false);
        add(textScreen, BorderLayout.CENTER);
        this.textScreen.setEditable(false);
        Panel panel = new Panel();
        panel.add(buttonUse);
        panel.add(buttonAlarm);
        panel.add(buttonPhone);
        panel.add(buttonExit);
        add(panel, BorderLayout.SOUTH);

        // 表示
        pack();
        setVisible(true);

        // Event Listenerの設定
        this.buttonUse.addActionListener(e -> this.state.doUse(this));
        this.buttonAlarm.addActionListener(e -> this.state.doAlarm(this));
        this.buttonPhone.addActionListener(e -> this.state.doPhone(this));
        this.buttonExit.addActionListener(e -> System.exit(0));
    }

    @Override
    public void setClock(int hour) {
        String clockString = String.format("現在時刻は%02d:00", hour);
        System.out.println(clockString);
        this.textClock.setText(clockString);
        this.state.doClock(this, this.isDay(hour));
    }

    private boolean isDay(int hour) {
        if (9 <= hour && hour < 17) {
            return true;
        }
        return false;
    }

    @Override
    public void changeState(State state) {
        System.out.println(this.state + "から" + state + "へ状態が変化しました。");
        this.state = state;
    }

    @Override
    public void callSecurityCenter(String message) {
        this.textScreen.append("call! " + message + "\n");
    }

    @Override
    public void recordLog(String message) {
        this.textScreen.append("record ... " + message + "\n");
    }
}