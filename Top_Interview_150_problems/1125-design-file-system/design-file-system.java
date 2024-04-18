class FileSystem {

    HashMap<String, Integer> fileSystem;

    public FileSystem() {
        fileSystem = new HashMap<>();
    }
    
    public boolean createPath(String path, int value) {
        if (fileSystem.containsKey(path)) {
            return false;
        }
        int rightIndex = path.lastIndexOf("/");
        
        if (path.substring(0, rightIndex) != "" && !fileSystem.containsKey(path.substring(0, rightIndex))){
            return false;
        }
        fileSystem.put(path, value);
        return true;
    }
    
    public int get(String path) {
        if (fileSystem.containsKey(path)) {
            return fileSystem.get(path);
        } else {
            return -1;
        }
    }
}

/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * boolean param_1 = obj.createPath(path,value);
 * int param_2 = obj.get(path);
 */