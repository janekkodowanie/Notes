package io.github.WegielWBucie.Notes.Logic;

import io.github.WegielWBucie.Notes.Model.*;
import io.github.WegielWBucie.Notes.Model.Projection.GroupReadModel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class NoteGroupServiceTest {

    @Test
    @DisplayName("Should throw IllegalArgumentException when there is no group with given ID.")
    void toggleGroup_noGroup_throwsIllegalArgumentException() {
        /* Given */
        var mockGroupRepository = mock(NoteGroupRepository.class);
        /* System under test */
        var toTest = new NoteGroupService(mockGroupRepository, null);
        /* When */
        var exception = catchThrowable(() -> toTest.toggleGroup(1L));
        /* Then */
        assertThat(exception)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("given ID not found");
    }

    @Test
    @DisplayName("Should toggle and save group.")
    void toggleGroup_groupExists_And_toggleAndSaveWork() {
        /* Given */
        var group = new NoteGroup();
        group.setTitle("GroupTitle");
        /* and */
        var mockGroupRepository = mock(NoteGroupRepository.class);
        when(mockGroupRepository.findByID(anyLong())).thenReturn(Optional.of(group));
        /* and */
        var noteRepository = mock(NoteRepository.class);
        /* and */
        String prevTitle = group.getTitle();
        /* System under test */
        var toTest = new NoteGroupService(mockGroupRepository, noteRepository);
        /* When */
        toTest.toggleGroup(anyLong());
        /* Then */
        assertThat(group.getTitle()).isNotEqualTo(prevTitle);
        assertThat(group.getTitle()).contains("<Closed>");
    }
}