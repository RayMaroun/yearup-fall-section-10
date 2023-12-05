### `Turtle` Class Methods

1. **Constructors:**
    - `Turtle(World w)`: Creates a turtle in the center of the world.
    - `Turtle(double x, double y, World w)`: Creates a turtle at a specified point in the world.

2. **Movement:**
    - `forward(double d)`: Moves the turtle forward by a specified distance.
    - `backward(double d)`: Moves the turtle backward by a specified distance.
    - `turnRight(double degrees)`: Turns the turtle clockwise by a specified number of degrees.
    - `turnLeft(double degrees)`: Turns the turtle counterclockwise by a specified number of degrees.
    - `goTo(double x, double y)`: Moves the turtle to a specific location.

3. **Pen Control:**
    - `penUp()`: Lifts the pen, stopping the turtle from drawing.
    - `penDown()`: Puts the pen down, allowing the turtle to draw.
    - `isPenDown()`: Returns whether the pen is down.

4. **Appearance:**
    - `setColor(Color color)`: Sets the color of the turtle’s pen.
    - `getColor()`: Returns the current color of the turtle’s pen.
    - `setPenWidth(double width)`: Sets the width of the turtle's pen.
    - `getPenWidth()`: Gets the current pen width.
    - `setShellSize(double shellSize)`: Sets the size of the turtle's shell.

5. **Utility:**
    - `getHeading()`: Returns the current direction the turtle is facing.
    - `setHeading(double angle)`: Sets the direction the turtle is facing.
    - `getLocation()`: Returns the current location of the turtle.
    - `setDelay(double seconds)`: Sets the delay between turtle movements.
    - `drop(String filename, double size)`: Places an image at the turtle's location.

### `World` Class Methods

1. **Constructors:**
    - `World()`: Creates a new world with default size.
    - `World(int width, int height)`: Creates a world with specified width and height.
    - `World(int width, int height, Color backgroundColor)`: Creates a world with specific dimensions and background color.

2. **Turtle Management:**
    - `addTurtle(Turtle t)`: Adds a turtle to the world.
    - `turtleMoved()`: Updates the world when a turtle moves.

3. **Graphics and Drawing:**
    - `erase()`: Erases all paths drawn in the world.
    - `drawLine(Point2D p1, Point2D p2, double width, Color color)`: Draws a line in the world.
    - `drawImage(Image img, AffineTransform placement)`: Draws an image in the world.

4. **Utility:**
    - `saveAs(String filename)`: Saves the current view of the world to a file.

You can use these methods to create various turtle graphics and teach basic concepts of object-oriented programming, method invocation, and Java graphics.