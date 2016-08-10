package sample;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;

import java.util.Random;

public class Controller {
    @FXML
    Label debugLabel;

    @FXML
    Canvas canvas;

    @FXML
    public void paintRect(ActionEvent e) {
        new PaintThread(Shape.RECT, "Shape Rectangle!)", debugLabel, canvas);
    }

    @FXML
    protected void paintCircle(ActionEvent e) {
        new PaintThread(Shape.OVAL, "Shape Circle!", debugLabel, canvas);
    }

    @FXML
    private void clearCanvas() {
        new PaintThread(Shape.CLR, "Clearing Canvas!", debugLabel, canvas);
    }
}

class PaintThread extends Thread {
    private Shape shape;
    private String msg;

    private Label label;
    private Canvas canvas;

    public PaintThread(Shape shape, String msg, Label label, Canvas canvas) {
        this.shape = shape;
        this.msg = msg +  " | Displaying Thread: " + Thread.currentThread();
        this.label = label;
        this.canvas = canvas;

        start();
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Platform.runLater(new UIThreadDispatcher(shape, msg, label, canvas));
    }
}

class UIThreadDispatcher implements Runnable {
    private Shape shape;
    private String msg;

    private Label label;
    private Canvas canvas;

    public UIThreadDispatcher(Shape shape, String msg, Label label, Canvas canvas) {
        this.shape = shape;
        this.msg = msg + " | Executed on Thread: " + Thread.currentThread();
        this.label = label;
        this.canvas = canvas;
    }

    @Override
    public void run() {
        System.out.println(msg);
        label.setText(msg);

        Random r = new Random();

        //position and size
        int w = r.nextInt((int) canvas.getWidth());
        int x = r.nextInt((int) canvas.getWidth() - w);
        int h = r.nextInt((int) canvas.getHeight());
        int y = r.nextInt((int) canvas.getHeight() - h);

        //color
        GraphicsContext gc = canvas.getGraphicsContext2D();

        gc.setStroke(Color.BLACK);
        gc.setFill(new Color(r.nextDouble(), r.nextDouble(), r.nextDouble(), r.nextDouble()));

        if (shape == Shape.RECT) {
            gc.strokeRect(x, y, w, h);
            gc.fillRect(x, y, w, h);
        }
        else if (shape == Shape.OVAL) {
            gc.strokeOval(x, y, w, h);
            gc.fillOval(x, y, w, h);
        }
        else if (shape == Shape.CLR) {
            gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
            gc.strokeRect(0, 0, canvas.getWidth(), canvas.getHeight());
        }
    }
}

enum Shape {
    RECT, OVAL, CLR
}
