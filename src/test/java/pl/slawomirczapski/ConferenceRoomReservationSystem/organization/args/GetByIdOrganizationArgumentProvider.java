package pl.slawomirczapski.ConferenceRoomReservationSystem.organization.args;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import pl.slawomirczapski.ConferenceRoomReservationSystem.organization.Organization;

import java.util.Arrays;
import java.util.Collections;
import java.util.Optional;
import java.util.stream.Stream;

public class GetByIdOrganizationArgumentProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) {
        return Stream.of(
                Arguments.of(
                        Arrays.asList(
                                new Organization("test1", "desc1"),
                                new Organization("test2", "desc2"),
                                new Organization( "test3", "desc3"),
                                new Organization( "test4", "desc4"),
                                new Organization( "test5", "desc5")
                        ),
                        1L,
                        Optional.of(new Organization(1L,"test1", "desc1"))
                ),
                Arguments.of(
                        Collections.emptyList(),
                        1L,
                        Optional.empty()
                ),
                Arguments.of(
                        Arrays.asList(
                                new Organization( "test1", "desc1"),
                                new Organization( "test2", "desc2"),
                                new Organization( "test3", "desc3"),
                                new Organization( "test4", "desc4"),
                                new Organization( "test5", "desc5")
                        ),
                        400L,
                        Optional.empty()
                )
        );
    }
}
