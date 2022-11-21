package test.p1;

import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.Test;

import p1.RSStatus;
import p1.Route;
import p1.Segment;
import p1.Station;
import p1.Train;
import p1.TrainSystem;

/**
 * West Ruislip
 * North Action
 * Ealin Broadway
 * Notting Hill Gate
 * Baker Street
 * Stanmore
 * Bond Street
 * Westminster
 * Waterloo
 * Liverpool Street
 * Epping
 */
public class TrainSystemTest {

    @Test void testAddRoute() {
        TrainSystem ts = new TrainSystem();
        Route r = new Route("Notting Hill Gate - Westminster", RSStatus.Open, ts);
        ts.addRoute("Notting Hill Gate - Westminster");
        assertEquals("Routes should match", r, ts.getRoutes().get(0));
    }

    @Test void testAddSegment() {
        TrainSystem ts = new TrainSystem();
        Segment s = new Segment("West Ruislip to Notting Hill Gate", RSStatus.Open, ts, null);
        ts.addSegment("West Ruislip to Notting Hill Gate");
        assertEquals("Segments should match", s, ts.getSegments().get(0));
    }

    @Test void testAddStation() {
        TrainSystem ts = new TrainSystem();
        Station s = new Station("West Ruislip", RSStatus.Open, ts, null);
        ts.addStation("West Ruislip");
        assertEquals("Stations should match", s, ts.getStations().get(0));
    }

    @Test void testAddTrain() {
        TrainSystem ts = new TrainSystem();
        Train r = new Train(null, 235);
        ts.addTrain(r);
        assertEquals("Trains should match", r, ts.getTrains().get(0));
    }

    @Test void testAdvance() {

    }

    @Test void testCloseRoute() {

    }

    @Test void testCloseSegment() {

    }

    @Test void testCloseStation() {

    }

    @Test void testContainsRoute() {

    }

    @Test void testContainsSegment() {

    }

    @Test void testContainsStation() {

    }

    @Test void testContainsTrain() {

    }

    @Test void testDeRegisterTrain() {

    }

    @Test void testGetCurrentStatus() {

    }

    @Test void testGetRouteInfo() {

    }

    @Test void testGetSegmentInfo() {

    }

    @Test void testGetStationInfo() {

    }

    @Test void testGetTrainInfo() {

    }

    @Test void testOpenRoute() {

    }

    @Test void testOpenSegment() {

    }

    @Test void testOpenStation() {

    }

    @Test void testRegisterTrain() {

    }

    @Test void testRemoveRoute() {

    }

    @Test void testRemoveSegment() {

    }

    @Test void testRemoveStation() {

    }

    @Test void testRemoveTrain() {

    }

    @Test void testSetPaused() {

    }

    @Test void testSetStopped() {

    }

    @Test void testSetToWorking() {

    }

    @Test void testVerify() {

    }
}
