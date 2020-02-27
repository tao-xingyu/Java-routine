package task;

import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

import java.io.File;

public interface FileScanCallback {
    void execute(File dir);
}
