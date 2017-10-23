package challenges.algorithms.binarysearch;

class IceCream implements Comparable<IceCream>{
    int id;
    int price;

    IceCream(int id, int price) {
        this.id = id;
        this.price = price;
    }

    @Override
    public int compareTo(IceCream o) {
        if(price != o.price) {
            return price - o.price;
        } else {
            return id - o.id;
        }
    }

//    @Override
    public boolean equals(IceCream o){
        return price == o.price && id == o.id;
    }

}