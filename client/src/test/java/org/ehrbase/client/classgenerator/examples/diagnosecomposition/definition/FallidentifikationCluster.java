package org.ehrbase.client.classgenerator.examples.diagnosecomposition.definition;

import com.nedap.archie.rm.archetyped.FeederAudit;
import java.lang.String;
import org.ehrbase.client.annotations.Archetype;
import org.ehrbase.client.annotations.Entity;
import org.ehrbase.client.annotations.Path;

@Entity
@Archetype("openEHR-EHR-CLUSTER.case_identification.v0")
public class FallidentifikationCluster {
  /**
   * COVID-19-Diagnose/context/Fallidentifikation/Fall-Kennung
   */
  @Path("/items[at0001]/value|value")
  private String fallKennungValue;

  /**
   * COVID-19-Diagnose/context/Fallidentifikation/feeder_audit
   */
  @Path("/feeder_audit")
  private FeederAudit feederAudit;

  public void setFallKennungValue(String fallKennungValue) {
     this.fallKennungValue = fallKennungValue;
  }

  public String getFallKennungValue() {
     return this.fallKennungValue ;
  }

  public void setFeederAudit(FeederAudit feederAudit) {
     this.feederAudit = feederAudit;
  }

  public FeederAudit getFeederAudit() {
     return this.feederAudit ;
  }
}
