package io.github.WegielWBucie.Notes.Controller;

import io.github.WegielWBucie.Notes.NoteConfigurationProperties;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
class InfoController {

    private DataSourceProperties dataSource;

    private NoteConfigurationProperties myProp;

     InfoController(final DataSourceProperties dataSource, final NoteConfigurationProperties myProp) {
        this.dataSource = dataSource;
        this.myProp = myProp;
    }

    @GetMapping("/info/url")
    String url() {
        return this.dataSource.getUrl();
    }

    @GetMapping("/info/prop")
    boolean myProp() {
        return this.myProp.getTemplate().isAllowMultipleNotes();
    }
}