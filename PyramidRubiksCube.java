package org.example;
import java.util.HashMap;
import java.util.Map;

/**
 * Represents Pyramid Rubik's Cube with 4 triangular faces.
 * Each face has 9 tiles arranged in triangular pattern:
 *     0
 *   1 2 3
 * 4 5 6 7 8
 * The numbers are indices of tiles represented as 2D array
 * Different parts of cube can be accessed by using indices
    * edges: 1, 3, 6
    * centers: 2, 5, 7
    * tips: 0, 4, 8
    * upper triangle: 0,1,2,3
    * left triangle: 1,4,5,6
    * right triangle: 3,6,7,8
*/
public class PyramidRubiksCube {
    // Core data structures to represent the cube
    private String[][] faces;      // 2D array storing all faces
    private Map<String, String[]> cube;  // HashMap mapping face names to their tiles

    // Additional structures for specific tile types
    private String[][] edges;      // Stores edge pieces (tiles 1, 3, 6 of each face)
    private String[][] tips;       // Stores corner pieces (tiles 0, 4, 8 of each face)

    /**
     * Initializes new Pyramid Rubik's Cube in solved state.
     * Each face initialized with a single color:
     * - Front: Red (R)
     * - Right: Blue (B)
     * - Left: Green (G)
     * - Base: Yellow (Y)
     */
    public PyramidRubiksCube() {
        initializeFaces();
        initializeEdges();
        initializeTips();
    }

    /**
     * Validates current state of cube.
     * Checks:
     * 1. All faces exist & have 9 tiles
     * 2. Each color appears 9 times across all faces
     * @throws RuntimeException if any validation fails
     */
    public void validateCube() {
        // List of all face keys we expect to find
        String[] faceKeys = {"Front", "Right", "Left", "Base"};
        
        // Check each face has exactly 9 tiles
        for (String faceKey : faceKeys) {
            String[] face = cube.get(faceKey);
            if (face == null) {
                throw new RuntimeException("Missing face: " + faceKey);
            }
            if (face.length != 9) {
                throw new RuntimeException("Expected 9 tiles, but found " + face.length);
            }
        }

        // Count occurrences of each color
        int blueCount = 0;
        int greenCount = 0;
        int redCount = 0;
        int yellowCount = 0;
        for (String faceKey : faceKeys) {
            String[] face = cube.get(faceKey);
            for (String tile : face) {
                switch (tile) {
                    case "B" -> blueCount++;
                    case "G" -> greenCount++;
                    case "R" -> redCount++;
                    case "Y" -> yellowCount++;
                }
            }
        }
        // Verify each color appears exactly 9 times
        if (blueCount != 9 || greenCount != 9 || redCount != 9 || yellowCount != 9) {
            throw new RuntimeException("Expected 9 of each color, but found " + blueCount + " blue, " + greenCount + " green, " + redCount + " red, " + yellowCount + " yellow");
        }
    }

    /**
     * Initializes faces of cube in solved state.
     * Creates main cube HashMap and assigns each face initial colors.
     */
    private void initializeFaces() {
        faces = new String[][]{
                {"R","R","R","R","R","R","R","R","R"},  // Front face (Red)
                {"B","B","B","B","B","B","B","B","B"},  // Right face (Blue)
                {"G","G","G","G","G","G","G","G","G"},  // Left face (Green)
                {"Y","Y","Y","Y","Y","Y","Y","Y","Y"}   // Base face (Yellow)
        };
        cube = new HashMap<>();
        cube.put("Front", faces[0]); // red
        cube.put("Right", faces[1]); // blue
        cube.put("Left", faces[2]); // green
        cube.put("Base", faces[3]); // yellow
    }

    /**
     * Initializes edge pieces of cube.
     * Edge pieces are tiles 1, 3, and 6 of each face.
     */
    private void initializeEdges() {
        edges = new String[][]{
                {cube.get("Front")[1], cube.get("Front")[3], cube.get("Front")[6]},
                {cube.get("Right")[1], cube.get("Right")[3], cube.get("Right")[6]},
                {cube.get("Left")[1], cube.get("Right")[3], cube.get("Right")[6]},
                {cube.get("Base")[1], cube.get("Base")[3], cube.get("Base")[6]}
        };
        cube.put("frontEdges", edges[0]);
        cube.put("rightEdges", edges[1]);
        cube.put("leftEdges", edges[2]);
        cube.put("baseEdges", edges[3]);
    }

    /**
     * Initializes tip pieces of cube.
     * Tip pieces are tiles 0, 4, and 8 of each face.
     */
    private void initializeTips() {
        tips = new String[][]{
                {cube.get("Front")[0], cube.get("Front")[4], cube.get("Front")[8]},
                {cube.get("Right")[0], cube.get("Right")[4], cube.get("Right")[8]},
                {cube.get("Left")[0], cube.get("Right")[4], cube.get("Right")[8]},
                {cube.get("Base")[0], cube.get("Base")[4], cube.get("Base")[8]}
        };
        cube.put("frontTips", tips[0]);
        cube.put("rightTips", tips[1]);
        cube.put("leftTips", tips[2]);
        cube.put("baseTips", tips[3]);
    }

    /**
     * Prints visual representation of each face of pyramid.
     * Each face printed in triangular pattern showing 9 tiles.
     */
    public void printPyramid() {
        String[] faces = {"Front", "Right", "Left", "Base"};
        String template = """
                            %s
                          %s %s %s
                        %s %s %s %s %s
                        """;
        
        for (String face : faces) {
            String[] tiles = cube.get(face);
            System.out.printf(template, 
                tiles[0], tiles[1], tiles[2], tiles[3], 
                tiles[4], tiles[5], tiles[6], tiles[7], tiles[8]);
        }
    }

    /**
     * Main method to demonstrate cube initialization and validation.
     */
    public static void main(String[] args) {
        PyramidRubiksCube p = new PyramidRubiksCube(); // creates new cube
        p.printPyramid(); // prints current state of cube

        // checks if cube is valid
        try {
            p.validateCube();
            System.out.println("Cube is valid");
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }
}
