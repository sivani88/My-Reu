package configure;

import com.example.maru.BuildConfig;

public class BuildConfigResolver {
    public boolean isDebug(){
        return BuildConfig.DEBUG;
    }
}
