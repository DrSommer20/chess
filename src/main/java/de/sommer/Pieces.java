package de.sommer;

import java.util.ArrayList;
import java.util.HashMap;

public class Pieces {

    private HashMap<Coordinate, Piece> pieces;
    private HashMap<Coordinate, Piece> previousPieces;
    private boolean isCaptured = false;
    private ArrayList<HashMap<Coordinate, Piece>> gameProgress = new ArrayList<>();

    public Pieces(){
        pieces = new HashMap<>();
        previousPieces = copyHashMap(pieces);
        gameProgress.add(copyHashMap(pieces));
    }

    // Getters and Setters

    public HashMap<Coordinate, Piece> getPieces(){
        return pieces;
    }

    public void setPieces(HashMap<Coordinate, Piece> pieces){
        this.pieces = pieces;
    }

    public HashMap<Coordinate, Piece> getPreviousPieces(){
        return previousPieces;
    }

    public void setPreviousPieces(HashMap<Coordinate, Piece> previousPieces){
        this.previousPieces = previousPieces;
    }

    public boolean getIsCaptured(){
        return isCaptured;
    }

    public void setIsCaptured(boolean isCaptured){
        this.isCaptured = isCaptured;
    }

    public ArrayList<HashMap<Coordinate, Piece>> getGameProgress(){
        return gameProgress;
    }

    public void setGameProgress(ArrayList<HashMap<Coordinate, Piece>> gameProgress){
        this.gameProgress = gameProgress;
    }

    // Methods

    public void addPiece(Piece piece, Coordinate coordinate){
        pieces.put(coordinate, piece);
    }

    public void removePiece(Coordinate coordinate){
        pieces.remove(coordinate);
    }

    private HashMap<Coordinate, Piece> copyHashMap (HashMap<Coordinate, Piece> original) { // creates a copy of a pieces HashMap

        HashMap<Coordinate, Piece> copyMap = new HashMap<>();
        for (Coordinate key : original.keySet()) {
            Coordinate newKey = new Coordinate(key);
            Piece newPiece = original.get(key).copy();
            copyMap.put(newKey,newPiece);
        }

        return copyMap;
    }
}
