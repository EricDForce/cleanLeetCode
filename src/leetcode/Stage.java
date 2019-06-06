public class Stage{
        int peoplex;
        int peopley;
        int boxx;
        int boxy;
        Stage previous;

        public static void main(String[] args){
            Stage st = new Stage();
            System.out.println(st);
        }
        public Stage(int peoplex, int peopley) {
            this.peoplex = peoplex;
            this.peopley = peopley;
        }

        public Stage(int peoplex, int peopley, int boxx, int boxy) {
            this.peoplex = peoplex;
            this.peopley = peopley;
            this.boxx = boxx;
            this.boxy = boxy;
        }

        @Override
        public String toString() {
            return "people:(" + this.peoplex + "," + this.peopley + ")  box:(" + this.boxx+"," + this.boxy + ")";
        }

        public Stage() {}

        public boolean equals(Object obj) {
            if (obj instanceof Stage) {
                if (((Stage) obj).peoplex==peoplex&&((Stage) obj).peopley==peopley&&((Stage) obj).boxx==boxx&&((Stage) obj).boxy==boxy)return true;
            }
            return false;
        }
    }
