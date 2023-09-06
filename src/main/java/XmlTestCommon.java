

import static java.nio.charset.StandardCharsets.UTF_8;
import static java.util.stream.Collectors.joining;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.Set;

import org.eclipse.rdf4j.model.Model;
import org.eclipse.rdf4j.rio.RDFFormat;

import io.carml.engine.rdf.RdfRmlMapper;
import io.carml.logicalsourceresolver.CsvResolver;
import io.carml.logicalsourceresolver.JsonPathResolver;
import io.carml.logicalsourceresolver.XPathResolver;
import io.carml.model.TriplesMap;
import io.carml.util.RmlMappingLoader;
import io.carml.vocab.Rdf;

public class XmlTestCommon {

	private static String getResourceAsString(final String name) {
		try (final InputStream inputStream = XmlTestCommon.class.getClassLoader().getResourceAsStream(name)) {
			if (inputStream == null)
				throw new RuntimeException(String.format("Can't find resource: %s", name));


			try (final InputStreamReader isr = new InputStreamReader(inputStream, UTF_8.toString());
					final BufferedReader reader = new BufferedReader(isr)) {
				return reader.lines().collect(joining(System.lineSeparator()));
			}
		} catch (final IOException e) {
			throw new RuntimeException(String.format("Can't load resource: %s", name), e);
		}
	}

	public static final String sourceString = getResourceAsString("personoccupation-guid-20c7bd94-fc0b-44d5-a13d-04ec21c95a92.xml");
	public static final String mappingString = getResourceAsString("personOccupation-mapping.ttl");

	public static void doConversion_0() {
		Set<TriplesMap> carmlMapping = RmlMappingLoader.build().load(
				RDFFormat.TURTLE,
				new ByteArrayInputStream(mappingString.getBytes()));

		RdfRmlMapper mapper = RdfRmlMapper.builder()
				.triplesMaps(carmlMapping)
				.setLogicalSourceResolver(Rdf.Ql.JsonPath, JsonPathResolver::getInstance)
				.setLogicalSourceResolver(Rdf.Ql.XPath, XPathResolver::getInstance)
				.setLogicalSourceResolver(Rdf.Ql.Csv, CsvResolver::getInstance)
				.build();

		Model m = mapper.mapToModel(Map.of("stdin", new ByteArrayInputStream(sourceString.getBytes())));
	}

}
