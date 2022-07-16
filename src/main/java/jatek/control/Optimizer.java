package jatek.control;

/*
Ez az algoritmus, ami a megkapott pálya és követzkező alakzat alapján belövi, hogy mi lenne a jó lépés
Az egészet kb innen vettem: https://medium.com/python-pandemonium/building-a-tetris-bot-part-1-the-stupid-bot-2cbc38d6e32b
 */
public class Optimizer {
//
//    TrackElement[][] track;
//    TetrisElement current;
//
//    @Autowired
//    private LeftRotator leftRotator;
//
//    public void getOptimalDrop(TrackElement[][] track,TetrisElement current){
//        List<TetrisElement> possibleRotations = getAllRotationsForElement(current);
//
//        possibleRotations.forEach(rotation -> {
//            // végigiterálok az összes oszlopon, ezek számát a track[0].length-el tudtam begyűjteni
//        for(int i = 0; i < track[0].length; i++){
//            TrackElement[][] t = track;
//            drop(t,current, i);
//            // ha jó a drop, akkor bekerül a jó válaszok közé
//
//        }
//        });
//
//
//    }
//
//    private List<TetrisElement> getAllRotationsForElement(TetrisElement current) {
//        List<TetrisElement> returnlist = new ArrayList<>();
//        if(current.equals(TetrisElement.SQUARE)){
//            returnlist.add(TetrisElement.SQUARE);
//        } else if(current.equals(TetrisElement.LEFT_L)){
////            TetrisElement.LEFT_L;
////            for(int i = 0; i<4;i++){
////                returnlist.add(leftRotator.rotate();
//            }
//        return returnlist;
//        //ésígytovább
//        }
//
//
///*
//
//        Drops a tetromino in the specified column.
//        The leftmost column of the tetromino will be aligned with the specified
//        column.
//        Returns the row it was dropped in for computations.
//
// */
//    private int drop(TrackElement[][] t, TetrisElement current, int column ) {
//
//        Assert.isTrue(column >= 0);
//        Assert.isTrue(column + current.() <= track[0].length);
//        row = self._get_tetromino_drop_row(tetromino, column)
//        Assert.isTrue(row != -1);
//        self._place_tetromino(tetromino, row, column)
//        self._line_clear()
//        return row
//    }
//
//    def count_gaps(self):
//            """
//        Check each column one by one to make sure there are no gaps in the
//        column.
//        """
//            return sum(
//            ["".join([row[col] for row in self.state]).lstrip().count(' ')
//             for col in range(Field.WIDTH)])
//
//    def height(self):
//            """
//        Returns the height on the field of the highest placed tetromino on the
//        field.
//        """
//            for i, row in enumerate(self.state):
//            if ''.join(row).strip():
//            return Field.HEIGHT - i

}
