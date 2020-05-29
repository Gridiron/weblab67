package model.entity;


/**
 * Worker Entity
 * @author Mikita Ishchanka
 * @version 1.0
 */
public class Worker {
    /**
     * Worker id
     */
    private int worker_id;
    /**
     * Name of worker
     */
    private String name;
    /**
     * Rank of worker
     */
    private int rank;

    public Worker(int id, String name, int rank) {
        this.worker_id = id;
        this.name = name;
        this.rank = rank;
    }

    public Worker() {
    }

    public int getWorker_id() {
        return worker_id;
    }

    public void setWorker_id(int worker_id) {
        this.worker_id = worker_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    @Override
    public String toString() {
        return "Worker{" +
                "worker_id=" + worker_id +
                ", name='" + name + '\'' +
                ", rank=" + rank +
                '}';
    }
}
