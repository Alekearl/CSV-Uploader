package com.http.program.uploadcsv.reader;

import com.http.program.uploadcsv.model.DataFile;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.util.List;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class ReaderCsv {
    public List<DataFile> fileReader(MultipartFile file) {
        try (Reader reader = new BufferedReader(new InputStreamReader(file.getInputStream(),
                StandardCharsets.UTF_8))) {
            CsvToBean<DataFile> csvToBean = new CsvToBeanBuilder<DataFile>(reader)
                    .withSkipLines(1)
                    .withSeparator(';')
                    .withType(DataFile.class)
                    .build();
            return csvToBean.parse();
        } catch (Exception e) {
            throw new RuntimeException("Wrong upload. Please select a CSV file to upload.", e);
        }
    }
}
