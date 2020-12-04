package org.ehrbase.client.classgenerator.examples.befundderblutgasanalysecomposition.definition;

import com.nedap.archie.rm.archetyped.FeederAudit;
import com.nedap.archie.rm.datastructures.Cluster;
import java.lang.Double;
import java.lang.String;
import java.util.List;
import org.ehrbase.client.annotations.Archetype;
import org.ehrbase.client.annotations.Entity;
import org.ehrbase.client.annotations.Path;

@Entity
@Archetype("openEHR-EHR-CLUSTER.laboratory_test_analyte.v1")
public class SauerstoffpartialdruckCluster {
  /**
   * Befund der Blutgasanalyse/Laborergebnis/Jedes Ereignis/Sauerstoffpartialdruck/untersuchter Analyt
   */
  @Path("/items[at0024]/value|defining_code")
  private UntersuchterAnalytDefiningCode2 untersuchterAnalytDefiningCode;

  /**
   * Befund der Blutgasanalyse/Laborergebnis/Jedes Ereignis/Sauerstoffpartialdruck/Analyt-Resultat
   */
  @Path("/items[at0001]/value|magnitude")
  private Double analytResultatMagnitude;

  /**
   * Befund der Blutgasanalyse/Laborergebnis/Jedes Ereignis/Sauerstoffpartialdruck/Analyt-Resultat
   */
  @Path("/items[at0001]/value|units")
  private String analytResultatUnits;

  /**
   * Befund der Blutgasanalyse/Laborergebnis/Jedes Ereignis/Sauerstoffpartialdruck/Analyseergebnis-Details
   */
  @Path("/items[at0014]")
  private List<Cluster> analyseergebnisDetails;

  /**
   * Befund der Blutgasanalyse/Laborergebnis/Jedes Ereignis/Sauerstoffpartialdruck/Ergebnis-Status
   */
  @Path("/items[at0005]/value|value")
  private String ergebnisStatusValue;

  /**
   * Befund der Blutgasanalyse/Laborergebnis/Jedes Ereignis/Sauerstoffpartialdruck/feeder_audit
   */
  @Path("/feeder_audit")
  private FeederAudit feederAudit;

  public void setUntersuchterAnalytDefiningCode(
      UntersuchterAnalytDefiningCode2 untersuchterAnalytDefiningCode) {
     this.untersuchterAnalytDefiningCode = untersuchterAnalytDefiningCode;
  }

  public UntersuchterAnalytDefiningCode2 getUntersuchterAnalytDefiningCode() {
     return this.untersuchterAnalytDefiningCode ;
  }

  public void setAnalytResultatMagnitude(Double analytResultatMagnitude) {
     this.analytResultatMagnitude = analytResultatMagnitude;
  }

  public Double getAnalytResultatMagnitude() {
     return this.analytResultatMagnitude ;
  }

  public void setAnalytResultatUnits(String analytResultatUnits) {
     this.analytResultatUnits = analytResultatUnits;
  }

  public String getAnalytResultatUnits() {
     return this.analytResultatUnits ;
  }

  public void setAnalyseergebnisDetails(List<Cluster> analyseergebnisDetails) {
     this.analyseergebnisDetails = analyseergebnisDetails;
  }

  public List<Cluster> getAnalyseergebnisDetails() {
     return this.analyseergebnisDetails ;
  }

  public void setErgebnisStatusValue(String ergebnisStatusValue) {
     this.ergebnisStatusValue = ergebnisStatusValue;
  }

  public String getErgebnisStatusValue() {
     return this.ergebnisStatusValue ;
  }

  public void setFeederAudit(FeederAudit feederAudit) {
     this.feederAudit = feederAudit;
  }

  public FeederAudit getFeederAudit() {
     return this.feederAudit ;
  }
}
