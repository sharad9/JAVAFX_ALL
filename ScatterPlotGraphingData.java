 import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.SceneAntialiasing;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Sphere;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;

public class ScatterPlotGraphingData extends Application {

    private static Random rnd = new Random();

    // size of graph
    int graphSize = 400;

    // variables for mouse interaction
    private double mousePosX, mousePosY;
    private double mouseOldX, mouseOldY;

    private final Rotate rotateX = new Rotate(150, Rotate.X_AXIS);
    private final Rotate rotateY = new Rotate(120, Rotate.Y_AXIS);

    @Override
    public void start(Stage primaryStage) {

        // create axis walls
        Group grid = createGrid(graphSize);

        // initial cube rotation
        grid.getTransforms().addAll(rotateX, rotateY);

        // add objects to scene
        StackPane root = new StackPane();
        root.getChildren().add(grid);

        root.setStyle( "-fx-border-color: red;");
        // create bars
        double gridSizeHalf = graphSize / 2;
        double size = 30;

        //Drawing a Sphere  
        Sphere sphere = new Sphere();  

        //Setting the properties of the Sphere
        sphere.setRadius(10.0);  

        //sphere.setTranslateX(-50);
        //sphere.setTranslateY(-50);      

        //Preparing the phong material of type specular color
        PhongMaterial material6 = new PhongMaterial();  

        //setting the specular color map to the material
        material6.setDiffuseColor(Color.GREEN);

        sphere.setMaterial(material6);

        grid.getChildren().addAll(sphere);

        // scene
        Scene scene = new Scene(root, 1600, 900, true, SceneAntialiasing.BALANCED);
        scene.setCamera(new PerspectiveCamera());

        scene.setOnMousePressed(me -> {
            mouseOldX = me.getSceneX();
            mouseOldY = me.getSceneY();
        });
        scene.setOnMouseDragged(me -> {
            mousePosX = me.getSceneX();
            mousePosY = me.getSceneY();
            rotateX.setAngle(rotateX.getAngle() - (mousePosY - mouseOldY));
            rotateY.setAngle(rotateY.getAngle() + (mousePosX - mouseOldX));
            mouseOldX = mousePosX;
            mouseOldY = mousePosY;

        });

        makeZoomable(root);

        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    /**
     * Axis wall
     */
    public static class Axis extends Pane {

        Rectangle wall;

        public Axis(double size) {

            // wall
            // first the wall, then the lines => overlapping of lines over walls
            // works
            wall = new Rectangle(size, size);
            getChildren().add(wall);

            // grid
            double zTranslate = 0;
            double lineWidth = 1.0;
            Color gridColor = Color.RED;

            for (int y = 0; y <= size; y += size / 10) {

                Line line = new Line(0, 0, size, 0);
                line.setStroke(gridColor);
                line.setFill(gridColor);
                line.setTranslateY(y);
                line.setTranslateZ(zTranslate);
                line.setStrokeWidth(lineWidth);

                getChildren().addAll(line);

            }

            for (int x = 0; x <= size; x += size / 10) {

                Line line = new Line(0, 0, 0, size);
                line.setStroke(gridColor);
                line.setFill(gridColor);
                line.setTranslateX(x);
                line.setTranslateZ(zTranslate);
                line.setStrokeWidth(lineWidth);

                getChildren().addAll(line);

            }

        }

        public void setFill(Paint paint) {
            wall.setFill(paint);
        }

    }

    public void makeZoomable(StackPane control) {

        final double MAX_SCALE = 20.0;
        final double MIN_SCALE = 0.1;

        control.addEventFilter(ScrollEvent.ANY, new EventHandler<ScrollEvent>() {

            @Override
            public void handle(ScrollEvent event) {

                double delta = 1.2;

                double scale = control.getScaleX();

                if (event.getDeltaY() < 0) {
                    scale /= delta;
                } else {
                    scale *= delta;
                }

                scale = clamp(scale, MIN_SCALE, MAX_SCALE);

                control.setScaleX(scale);
                control.setScaleY(scale);

                event.consume();

            }

        });

    }

    /**
     * Create axis walls
     *
     * @param size
     * @return
     */
    private Group createGrid(int size) {

        Group cube = new Group();

        // size of the cube
        Color color = Color.LIGHTGRAY;

        List<Axis> cubeFaces = new ArrayList<>();
        Axis r;

        // back face
        r = new Axis(size);
        r.setFill(color.deriveColor(0.0, 1.0, (1 - 0.5 * 1), 1.0));
        r.setTranslateX(-0.5 * size);
        r.setTranslateY(-0.5 * size);
        r.setTranslateZ(0.5 * size);

        cubeFaces.add(r);

        // bottom face
        r = new Axis(size);
        r.setFill(color.deriveColor(0.0, 1.0, (1 - 0.4 * 1), 1.0));
        r.setTranslateX(-0.5 * size);
        r.setTranslateY(0);
        r.setRotationAxis(Rotate.X_AXIS);
        r.setRotate(90);

        cubeFaces.add(r);

        // right face
        r = new Axis(size);
        r.setFill(color.deriveColor(0.0, 1.0, (1 - 0.3 * 1), 1.0));
        r.setTranslateX(-1 * size);
        r.setTranslateY(-0.5 * size);
        r.setRotationAxis(Rotate.Y_AXIS);
        r.setRotate(90);

        // cubeFaces.add( r);

        // left face
        r = new Axis(size);
        r.setFill(color.deriveColor(0.0, 1.0, (1 - 0.2 * 1), 1.0));
        r.setTranslateX(0);
        r.setTranslateY(-0.5 * size);
        r.setRotationAxis(Rotate.Y_AXIS);
        r.setRotate(90);

        cubeFaces.add(r);

        // top face
        r = new Axis(size);
        r.setFill(color.deriveColor(0.0, 1.0, (1 - 0.1 * 1), 1.0));
        r.setTranslateX(-0.5 * size);
        r.setTranslateY(-1 * size);
        r.setRotationAxis(Rotate.X_AXIS);
        r.setRotate(90);

        // cubeFaces.add( r);

        // front face
        r = new Axis(size);
        r.setFill(color.deriveColor(0.0, 1.0, (1 - 0.1 * 1), 1.0));
        r.setTranslateX(-0.5 * size);
        r.setTranslateY(-0.5 * size);
        r.setTranslateZ(-0.5 * size);

        // cubeFaces.add( r);

        cube.getChildren().addAll(cubeFaces);

        return cube;
    }

    public static double normalizeValue(double value, double min, double max, double newMin, double newMax) {

        return (value - min) * (newMax - newMin) / (max - min) + newMin;

    }

    public static double clamp(double value, double min, double max) {

        if (Double.compare(value, min) < 0)
            return min;

        if (Double.compare(value, max) > 0)
            return max;

        return value;
    }

    public static Color randomColor() {
        return Color.rgb(rnd.nextInt(255), rnd.nextInt(255), rnd.nextInt(255));
    }

    public static void main(String[] args) {
        launch(args);
    }
}