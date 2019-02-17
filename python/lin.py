'''public interface Intervals
{
 
     / **
     Adds an interval(from, to) into an internal structure.

    void addInterval(int from,  int to);
 
     / **
     *Returns
a
total
length
covered
by
the
added
intervals.
     *If
several
intervals
intersect, the
intersection
should
be
counted
only
once.
      * /
    int getTotalCoveredLength(); 
}

/ *
     *Example:
      *
     *addInterval(3, 6)
     *addInterval(8, 9)
     *addInterval(1, 5)
     *getTotalCoveredLength() -> 6
*removeRange(2, 4)
     *getTotalCoveredLength() -> 4
      *
      *
     *i.e.[1, 5) and [3, 6) intersect and give
a
total
covered
interval[1, 6) with a length of 5.
      *       [1, 6) and [8, 9) don
't intersect, so the total covered length is a sum of both intervals, that is 5+1=6.
      *
      *           | __ | __ | __ |                  (3, 6, blue)
      *                          | __ |         (8, 9, red)
      *     | __ | __ | __ | __ |                     (1, 5, yellow)

-> getTotalCoveredLength(blue) -> 3
-> getTotalCoveredLength(red) -> 1
-> getTotalCoveredLength(yellow) -> 4

      * | xxxxx |               -> 1 + 2 + 1 = 4
     *0  1  2  3  4  5  6  7  8  9  10

(-5, 1)

-5 - 4 - 3 - 2 - 1
0
1
2
3
4
5

*{4, 5, 6, 9, 2, 3}
{-4}
      *
* /
'''


class LinearInterval(object):

    def __init__(self):
        self.intervals_by_color = dict()

    def add_interval(self, frm, to, color):
        if to >= frm and color:
            if color in self.intervals_by_color:
                intervals = self.intervals_by_color[color]
            else:
                intervals = set()
                self.intervals_by_color[color] = intervals
            for i in range((frm+1), (to+1)):
                intervals.add(i)
        else:
            raise Exception("Invalid input for 'from' or 'to' arguments.")

    def remove_interval(self, frm, to, color):
        if to >= frm and color:
            if color in self.intervals_by_color:
                intervals = self.intervals_by_color[color]
                for i in range((frm+1), (to+1)):
                    if i in intervals:
                        intervals.remove(i)
            else:
                raise Exception("Invertals not found for color {color}".format(color=color))

        else:
            raise Exception("Invalid input for 'from' or 'to' arguments.")

    def get_total_covered_length(self, color):
        if color and color in self.intervals_by_color:
            intervals = self.intervals_by_color[color]
            return len(intervals)
        else:
            raise Exception("Invertals not found for color {color}".format(color=color))


if __name__== "__main__":
    li = LinearInterval()
    li.add_interval(3, 6, "blue")
    li.add_interval(8, 9, "blue")
    li.add_interval(1, 5, "blue")

    li.add_interval(8, 9, "red")
    li.add_interval(1, 5, "yellow")
    li.add_interval(2, 4, "blue")

    print("Blue : " + str(li.get_total_covered_length("blue")))
    print("Yellow : " + str(li.get_total_covered_length("yellow")))
