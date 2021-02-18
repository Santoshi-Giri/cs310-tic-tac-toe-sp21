package edu.jsu.mcis.cs310.tictactoe;

/**
* TicTacToeModel implements the Model for the Tic-Tac-Toe game.
*
* @author  Santoshi Giri
* @version 2.0
*/
public class TicTacToeModel {
    
    /**
     * The contents of the Tic-Tac-Toe game board
     */
    private TicTacToeSquare[][] board;
    
    /**
     * xTurn is true if X is the current player, or false if O is the current
     * player
     */
    private boolean xTurn;
    
    /**
     * The dimension (width and height) of the game board
     */
    private int dimension;

    /**
    * Default Constructor (uses the default dimension)
    */    
    public TicTacToeModel() {
        
        this(TicTacToe.DEFAULT_DIMENSION);
        
    }
    
    /**
    * Constructor (uses specified dimension)
    * 
    * @param dimension The <em>dimension</em> (width and height) of the new
    * Tic-Tac-Toe board.
    */
    public TicTacToeModel(int dimension) {
        
        /* Initialize dimension; X goes first */
        
        this.dimension = dimension;
        xTurn = true;
        
        /* Create board as a 2D TicTacToeSquare array */
        
        board = new TicTacToeSquare[dimension][dimension];

        /* Initialize board (fill with TicTacToeSquare.EMPTY) */
        
        // INSERT YOUR CODE HERE
           
	       
	        
	        for (int row=0; row<dimension; row++){
	            for (int column=0; column<dimension; column++){
	                board[row][column] = TicTacToeSquare.EMPTY;
	            }
	        }
	

	    }
	    /**
	    * Use isValidSquare(int, int) to check if the specified square is in range,
	    * and use isSquareMarked(int, int) to check if the square is currently
	    * empty.  If both conditions are satisfied, create a mark in the square for
	    * the current player, then toggle xTurn from true to false (or vice-versa)
	    * to switch to the other player before returning TRUE.  Otherwise, return
	    * FALSE.
	    *
	    * @param  row  the row (Y coordinate) of the square
	    * @param  col  the column (X coordinate) of the square
	    * @return      a Boolean value representing the result of the attempt to
	    * make this mark: true if the attempt was successful, and false otherwise
	    * @see         TicTacToeSquare
	    */
	    public boolean makeMark(int row, int col) {
	        if(isValidSquare(row, col) && !isSquareMarked(row, col)){
	            if (xTurn){
	                board[row][col] = TicTacToeSquare.X;
	                xTurn = false;
	            }
	            else{
	                board[row][col] = TicTacToeSquare.O; 
	                xTurn = true;
	            } 
	            return true;
	        }
	        return false;   
	    }
	    
	    /**
	    * Checks if the specified square is within range (that is, within the bounds
	    * of the game board).
	    *
	    * @param  row  the row (Y coordinate) of the square
	    * @param  col  the column (X coordinate) of the square
	    * @return      a Boolean value: true if the square is in range, and false
	    * if it is not
	    */
	    private boolean isValidSquare(int row, int col) {
	        
	        if (row>=0 && row<dimension && col>=0 && col<dimension)
	            return true;
	        else
	            return false; 
	    }
	    
	    /**
	    * Checks if the specified square is marked.
	    *
	    * @param  row  the row (Y coordinate) of the square
	    * @param  col  the column (X coordinate) of the square
	    * @return      a Boolean value: true if the square is marked, and false
	    * if it is not
	    */
	    private boolean isSquareMarked(int row, int col) {
	                
	        if(board[row][col] == TicTacToeSquare.EMPTY)
	            return false; 
	        else
	            return true;
	            
	    }
	    
	    /**
	    * Returns a {@link TicTacToeSquare} object representing the content of the
	    * specified square of the Tic-Tac-Toe board.
	    *
	    * @param  row  the row (Y coordinate) of the square
	    * @param  col  the column (X coordinate) of the square
	    * @return      the content of the specified square
	    * @see         TicTacToeSquare
	    */
	    public TicTacToeSquare getSquare(int row, int col) {
	        
	        return board[row][col]; 
	            
	    }
	    
	    /**
	    * Use isMarkWin() to determine if X or O is the winner, if the game is a
	    * tie, or if the game is still in progress. Return the current state of the
	    * game as a {@link TicTacToeState} object.
	    *
	    * @return      the current state of the Tic-Tac-Toe game
	    * @see         TicTacToeState
	    */
	    public TicTacToeState getState() {
	        TicTacToeState state = TicTacToeState.NONE;
	

	        if(isMarkWin(TicTacToeSquare.X)){
	            return state.X;
	        }
	        else if(isMarkWin(TicTacToeSquare.O)){
	            return state.O;
	        }
	        else if(isTie()){
	            return state.TIE;
	        }
	        return state; 
	        
	    }
	    
	    /**
	    * Check the squares of the Tic-Tac-Toe board to see if the specified player
	    * is the winner.
	    *
	    * @param  mark  the mark representing the player to be checked (X or O)
	    * @return       true if the specified player is the winner, or false if not
	    * @see          TicTacToeSquare
	    */
	    private boolean isMarkWin(TicTacToeSquare mark) {
	

	        int numMarks; 
	

	        //check each row
	        numMarks = 0; 
	        for(int row=0; row<dimension; row++){
	            for(int column=0; column<dimension; column++){
	                if(mark == getSquare(row, column)){
	                    numMarks++; 
	                }
	            }
	            if (numMarks == dimension){
	                return true;
	            }
	            else{
	                numMarks = 0; 
	            }
	        }
	

	        //check each column
	        numMarks = 0; 
	        for(int column=0; column<dimension; column++){
	            for(int row=0; row<dimension; row++){
	                if(mark == getSquare(row, column)){
	                    numMarks++; 
	                }
	            }
	            if(numMarks == dimension){
	                return true;
	            }
	            else{
	                numMarks = 0; 
	            }
	        }
	

	        //check each diagonal: top left to bottom right
	        numMarks = 0;
	        int row = 0;
	        int column = 0; 
	        while(row<dimension && column<dimension){
	            if(mark == getSquare(row, column)){
	                numMarks++; 
	            }
	            row++; 
	            column++; 
	        }
	        if(numMarks == dimension){
	            return true;
	        }
	

	        //check each diagonal: bottom left to top right
	        numMarks = 0;
	        row = dimension-1; 
	        column = 0; 
	        while(row>=0 && column<dimension){
	            if(mark == getSquare(row, column)){
	                numMarks++; 
	            }
	            row--; 
	            column++; 
	        }
	        if(numMarks == dimension){
	            return true;
	        }
	

	        return false; 
	        
	    }
	    
	    /**
	    * Check the squares of the board to see if the Tic-Tac-Toe game is currently
	    * in a tie state.
	    *
	    * @return  true if the game is currently a tie, or false otherwise
	    */	
	    private boolean isTie() {
	        
	        for (int row=0; row<dimension; row++){
	            for (int column=0; column<dimension; column++){
	                if(!isSquareMarked(row, column)){
	                    return false; //if unmarked square is found
	                }
	            }
	        }
	        return true; //if all squares are marked
	        
	    }
	

	    /**
	    * Uses {@link #getState() getState} to checks if the Tic-Tac-Toe game is
	    * currently over, either because a player has won or because the game is
	    * in a tie state.
	    *
	    * @return  true if the game is currently over, or false otherwise
	    */	
	    public boolean isGameover() {
	        
	        return TicTacToeState.NONE != getState();
	        
	    }
	

	    /**
	    * Getter for xTurn.
	    *
	    * @return  true if X is the current player, or false if O is the current
	    * player
	    */
	    public boolean isXTurn() {
	        
	        return xTurn;
	        
	    }
	    
	    /**
	    * Getter for dimension.
	    *
	    * @return  the <em>dimension</em> (width and height) of the Tic-Tac-Toe
	    * game board
	    */
	    public int getDimension() {
	        
	        return dimension;
	        
	    }
	    
	    /**
	    * <p>Returns the current content and state of the Tic-Tac-Toe game board as
	    * a formatted String.  This method <em>must</em> use a {@link StringBuilder}
	    * to compose the output String, which should not include any empty lines.</p>
	    * <p>Here is an example of how the output for a 3x3 game board should
	    * appear (also see the example output on Canvas):</p>
	    * <code>&nbsp;&nbsp;012<br>0&nbsp;O&nbsp;&nbsp;<br>1&nbsp;&nbsp;X&nbsp;<br>2&nbsp;O&nbsp;X</code>
	    * @return      the representation of the Tic-Tac-Toe game board
	    * @see         StringBuilder
	    */
	    @Override
	    public String toString() {
	        
	        StringBuilder output = new StringBuilder();
	        
	        output.append("\n"); 
	        output.append(" ").append(" "); //blank spaces at top left corner of game board
	

	        //print column numbers on first row
	        for (int column = 0; column<dimension; column++){
	            output.append(column);
	        }
	

	        output.append("\n");
	

	        //print each row
	        for(int row=0; row<dimension; row++){
	            output.append(row).append(" "); 
	            for (int column=0; column<dimension; column++){
	            
	                output.append(getSquare(row, column)); 
	            }
	            output.append("\n"); 
	        }
	        output.append("\n"); 
	

	        return output.toString();
	        
	    }
	    
	}


        
    
    