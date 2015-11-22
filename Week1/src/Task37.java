
public class Task37 {
	static String reduceFilepath(String path) {
		path = path.replaceAll("\\/+", "\\/")
		           .replaceAll("(?:\\/[\\w\\d]+)?\\/\\.\\.", "")
		           .replaceAll("\\/\\.", "")
		           .replaceAll("[^^]\\/$", "");
		
		return path;
	}
}
