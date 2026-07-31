package org.example;

public class MyService {
    private final ExternalApi api;

    public MyService(ExternalApi api){
        this.api=api;
    }
    public String fetchData(){
        return api.getData();
    }
    public String getUserInfo(String id){
        return api.processUser(id);
    }
    public void save(String info){
        api.saveData(info);
    }
    public void auditWorkflow(String user){
        api.logActivity("Start: " + user);
        api.logActivity("End: " + user);
    }


}
