package model.entity;

/**
 * Task Entity
 * @author Mikita Ishchanka
 * @version 1.0
 */
public class Task {
    /**
     * Task id
     */
    private int task_id;

    /**
     * Worker of task
     */
    private int workerId;

    /**
     * Client of task
     */
    private int clientId;
    /**
     * Name of task
     */
    private String name;
    /**
     * Rank needed for task
     */
    private int rank_needed;
    /**
     * Paid or not paid
     */
    private int is_paid;

    public Task(int task_id, int workerId, int clientId, String name, int rank_needed, int is_paid) {
        this.task_id = task_id;
        this.workerId = workerId;
        this.clientId = clientId;
        this.name = name;
        this.rank_needed = rank_needed;
        this.is_paid = is_paid;
    }

    public Task() {
    }

    public int getWorkerId() {
        return workerId;
    }

    public void setWorkerId(int workerId) {
        this.workerId = workerId;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRank_needed() {
        return rank_needed;
    }

    public void setRank_needed(int rank_needed) {
        this.rank_needed = rank_needed;
    }

    public int getIs_paid() {
        return is_paid;
    }

    public void setIs_paid(int is_paid) {
        this.is_paid = is_paid;
    }

    public int getTask_id() {
        return task_id;
    }

    public void setTask_id(int task_id) {
        this.task_id = task_id;
    }

    @Override
    public String toString() {
        return "Task{" +
                "task_id=" + task_id +
                ", worker=" + workerId +
                ", client=" + clientId +
                ", name='" + name + '\'' +
                ", rank_needed=" + rank_needed +
                ", is_paid=" + is_paid +
                '}';
    }
}

