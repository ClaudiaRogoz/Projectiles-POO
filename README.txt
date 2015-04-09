Rogoz Claudia
321 Ca

The implementation of this homework is based on the code provided.

The structure of this java project is described below:

The Project consists of 5 other packages besides the default one : Constants, ProcessingManagers, Projectiles, Screen, Shapes.

The default package provides 3 .java files : The Main - which intializes the proper Projectile class, FileParser - which opens a file to be read, and FileWritermatrix - which writes a matrix to a given "$file_out".

The Constants package contains as the name suggests, all the symbols(Dot_symbol, Triangle_symbol, etc.) and names used in the current project (TriGrapeShot, Carcass, etc.).

DrawManager and TimeManager are two classes used for drawing lines on the screen (given the edges of the lines) and for working with time.

In the Projectile package, there are all the projectiles extended. The inheritance hierarchy is based on the A->B->C from the bonus example.

Shapes provides a couple of basicshapes such as Dot, Point, Rectangle, Rhombus, Square and Triangle. All this classes compute the needed edges for the drawMultipleLinesOnScreen/drawLineOnScreen method.
 