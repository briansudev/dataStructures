/**============================ GRAPH ================================**/
/** Depth First Search. O(|v| + |e|). */
private void dfs(Graph G, int v) {
    marked[v] = true;
    for (int w : G.adj(v)) {
        if (!marked[w]) {
            dfs(G, w);
        }
    }
}

private void dfs_recur(Graph G, int v) {
	Stack<Vertex> fringe = new Stack<Vertex>();
	fringe.push(v);
	while (!fringe.isEmpty()) {
		Vertex t = fringe.pop();
		if (!marked(t)) {
			visit(t);
			mark(t);
			for (Vertex v : G.adj()) {
				fringe.push(v);
			}
		}
	}
}

/** Breadth first search. O(|v| + |e|). */
private void bfs(Graph G, int s) {
    Queue<Integer> q = new Queue<Integer>();
    //for (int v = 0; v < G.V(); v++) distTo[v] = INFINITY;
    //distTo[s] = 0;
    marked[s] = true;
    q.enqueue(s);

    while (!q.isEmpty()) {
        int v = q.dequeue();
        for (int w : G.adj(v)) {
            if (!marked[w]) {
                edgeTo[w] = v;
                //distTo[w] = distTo[v] + 1;
                marked[w] = true;
                q.enqueue(w);
            }
        }
    }
}

/**======================= INSERTION SORT =============================**/
public static void sort(Comparable[] a) {
    int N = a.length;
    for (int i = 0; i < N; i++) {
        for (int j = i; j > 0 && less(a[j], a[j-1]); j--) {
            exch(a, j, j-1);
        }
    }
}
 
/**======================= SELECTION SORT =============================**/
public static void sort(Comparable[] a) {
    int N = a.length;
    for (int i = 0; i < N; i++) {
        int min = i;
        for (int j = i+1; j < N; j++) {
            if (less(a[j], a[min])) min = j;
        }
        exch(a, i, min);
    }
}

/**========================= HEAPSORT ===============================**/

public static void sort(Comparable[] pq) {
    int N = pq.length;
    for (int k = N/2; k >= 1; k--) // Reheapify
        sink(pq, k, N);
    while (N > 1) {
        exch(pq, 1, N--);
        sink(pq, 1, N);
    }
}

private static void sink(Comparable[] pq, int k, int N) {
    while (2*k <= N) {
        int j = 2*k;
        if (j < N && less(pq, j, j+1)) j++;
        if (!less(pq, k, j)) break;
        exch(pq, k, j);
        k = j;
    }
}
/**========================= SHELL SORT ===============================**/
public static void sort(Comparable[] a) {
    int N = a.length;

    // 3x+1 increment sequence:  1, 4, 13, 40, 121, 364, 1093, ... 
    int h = 1;
    while (h < N/3) h = 3*h + 1; 

    while (h >= 1) {
        // h-sort the array
        for (int i = h; i < N; i++) {
            for (int j = i; j >= h && less(a[j], a[j-h]); j -= h) {
                exch(a, j, j-h);
            }
        }
        h /= 3;
    }
}

/**========================= MERGE SORT ===============================**/
// mergesort a[lo..hi] using auxiliary array aux[lo..hi]
private static void sort(Comparable[] a, Comparable[] aux, int lo, int hi) {
    if (hi <= lo) return;
    int mid = lo + (hi - lo) / 2;
    sort(a, aux, lo, mid);
    sort(a, aux, mid + 1, hi);
    merge(a, aux, lo, mid, hi);
}

// stably merge a[lo .. mid] with a[mid+1 ..hi] using aux[lo .. hi]
private static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {

    // precondition: a[lo .. mid] and a[mid+1 .. hi] are sorted subarrays
    assert isSorted(a, lo, mid);
    assert isSorted(a, mid+1, hi);

    // copy to aux[]
    for (int k = lo; k <= hi; k++) {
        aux[k] = a[k]; 
    }

    // merge back to a[]
    int i = lo, j = mid+1;
    for (int k = lo; k <= hi; k++) {
        if      (i > mid)              a[k] = aux[j++];   // this copying is unnecessary
        else if (j > hi)               a[k] = aux[i++];
        else if (less(aux[j], aux[i])) a[k] = aux[j++];
        else                           a[k] = aux[i++];
    }
}

/**========================= QUICK SORT ===============================**/
// quicksort the subarray from a[lo] to a[hi]
private static void sort(Comparable[] a, int lo, int hi) { 
    if (hi <= lo) return;
    int j = partition(a, lo, hi);
    sort(a, lo, j-1);
    sort(a, j+1, hi);
}

// partition the subarray a[lo..hi] so that a[lo..j-1] <= a[j] <= a[j+1..hi]
// and return the index j.
private static int partition(Comparable[] a, int lo, int hi) {
    int i = lo;
    int j = hi + 1;
    Comparable v = a[lo];
    while (true) { 

        // find item on lo to swap
        while (less(a[++i], v))
            if (i == hi) break;

        // find item on hi to swap
        while (less(v, a[--j]))
            if (j == lo) break;      // redundant since a[lo] acts as sentinel

        // check if pointers cross
        if (i >= j) break;

        exch(a, i, j);
    }

    // put partitioning item v at a[j]
    exch(a, lo, j);

    // now, a[lo .. j-1] <= a[j] <= a[j+1 .. hi]
    return j;
}

/**
 * Rearranges the array so that a[k] contains the kth smallest key;
 * a[0] through a[k-1] are less than (or equal to) a[k]; and
 * a[k+1] through a[N-1] are greater than (or equal to) a[k].
 * @param a the array
 * @param k find the kth smallest
 */
public static Comparable select(Comparable[] a, int k) {
    if (k < 0 || k >= a.length) {
        throw new IndexOutOfBoundsException("Selected element out of bounds");
    }
    StdRandom.shuffle(a);
    int lo = 0, hi = a.length - 1;
    while (hi > lo) {
        int i = partition(a, lo, hi);
        if      (i > k) hi = i - 1;
        else if (i < k) lo = i + 1;
        else return a[i];
    }
    return a[lo];
}

/**========================= BINARY SEARCH ===============================**/
public static int rank(int key, int[] a) {
    int lo = 0;
    int hi = a.length - 1;
    while (lo <= hi) {
        // Key is in a[lo..hi] or not present.
        int mid = lo + (hi - lo) / 2;
        if      (key < a[mid]) hi = mid - 1;
        else if (key > a[mid]) lo = mid + 1;
        else return mid;
    }
    return -1;
}

/**============================ MAX/MIN HEAP ===================================**/
public void insert(Key x) {

    // double size of array if necessary
    if (N >= pq.length - 1) resize(2 * pq.length);

    // add x, and percolate it up to maintain heap invariant
    pq[++N] = x;
    swim(N);
}

public Key delMax() {
    if (isEmpty()) throw new NoSuchElementException("Priority queue underflow");
    Key max = pq[1];
    exch(1, N--);
    sink(1);
    pq[N+1] = null;     // to avoid loiterig and help with garbage collection
    if ((N > 0) && (N == (pq.length - 1) / 4)) resize(pq.length / 2);
    return max;
}

// helper function to double the size of the heap array
private void resize(int capacity) {
    assert capacity > N;
    Key[] temp = (Key[]) new Object[capacity];
    for (int i = 1; i <= N; i++) temp[i] = pq[i];
    pq = temp;
}

// For MAX HEAP
	private void swim(int k) {
	    while (k > 1 && less(k/2, k)) {
	        exch(k, k/2);
	        k = k/2;
	    }
	}

	private void sink(int k) {
	    while (2*k <= N) {
	        int j = 2*k;
	        if (j < N && less(j, j+1)) j++;
	        if (!less(k, j)) break;
	        exch(k, j);
	        k = j;
	    }
	}

// For MIN HEAP
    private void swim(int k) {
        while (k > 1 && greater(k/2, k)) {
            exch(k, k/2);
            k = k/2;
        }
    }

    private void sink(int k) {
        while (2*k <= N) {
            int j = 2*k;
            if (j < N && greater(j, j+1)) j++;
            if (!greater(k, j)) break;
            exch(k, j);
            k = j;
        }
    }